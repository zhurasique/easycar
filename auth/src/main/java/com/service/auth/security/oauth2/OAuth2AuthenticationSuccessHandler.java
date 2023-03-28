package com.service.auth.security.oauth2;

import com.service.auth.security.CookieUtils;
import com.service.auth.security.CustomOAuth2Token;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.service.auth.security.oauth2.HttpCookieOAuth2AuthorizationRequestRepository.REDIRECT_URI_PARAM_COOKIE_NAME;

@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Value("${TOKEN_SECRET}")
    private String tokenSecret;
    @Value("${TOKEN_LIFETIME}")
    private String tokenLifeTime;
    private final TokenStore tokenStore;
    private final HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(request, response, authentication);
        clearAuthenticationAttributes(request, response);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Optional<String> redirectUri = CookieUtils.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME)
                .map(Cookie::getValue);
        String targetUrl = redirectUri.orElse(getDefaultTargetUrl());
        CustomOAuth2Token t = new CustomOAuth2Token(authentication, tokenSecret, Integer.parseInt(tokenLifeTime));
        Map<String, String> tokenParams = new HashMap<>();
        tokenParams.put(OAuth2AccessToken.ACCESS_TOKEN, t.getAccessToken());
        tokenParams.put(OAuth2AccessToken.EXPIRES_IN, tokenLifeTime);
        tokenParams.put(OAuth2AccessToken.REFRESH_TOKEN, t.getRefreshToken());
        tokenParams.put(OAuth2AccessToken.SCOPE, "ui");
        tokenParams.put(OAuth2AccessToken.TOKEN_TYPE, OAuth2AccessToken.BEARER_TYPE.toLowerCase());
        OAuth2AccessToken token = new DefaultOAuth2AccessToken(DefaultOAuth2AccessToken.valueOf(tokenParams));
        OAuth2Authentication auth = new OAuth2Authentication(
                new OAuth2Request(null, "browser",
                        null, true,
                        new HashSet<>(List.of("ui")), null,
                        null, null,
                        null), authentication);
        tokenStore.storeAccessToken(token, auth);
        tokenStore.storeRefreshToken(token.getRefreshToken(), auth);
        return UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam(OAuth2AccessToken.ACCESS_TOKEN, token)
                .queryParam(OAuth2AccessToken.REFRESH_TOKEN, token.getRefreshToken())
                .build().toUriString();
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {
        super.clearAuthenticationAttributes(request);
        httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(request, response);
    }
}
