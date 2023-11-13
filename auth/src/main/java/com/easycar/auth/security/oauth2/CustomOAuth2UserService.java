package com.easycar.auth.security.oauth2;

import com.google.api.client.util.Base64;
import com.easycar.auth.client.AccountServiceClient;
import com.easycar.auth.domain.AuthProvider;
import com.easycar.auth.domain.User;
import com.easycar.auth.repository.UserRepository;
import com.easycar.auth.security.oauth2.user.OAuth2UserInfo;
import com.easycar.auth.security.oauth2.user.OAuth2UserInfoFactory;
import com.easycar.auth.vo.Account;
import com.easycar.auth.vo.AccountWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepo;
    private final AccountServiceClient accountServiceClient;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(
                oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
        Optional<User> userOptional = userRepo.findById(oAuth2UserInfo.getEmail());
        return userOptional.orElseGet(() -> registerNewUser(oAuth2UserRequest, oAuth2UserInfo));
    }

    @Transactional
    public User registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
        User user = new User();
        user.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
        user.setUsername(oAuth2UserInfo.getEmail());
        userRepo.save(user);
        Account account = new Account();
        account.setUsername(oAuth2UserInfo.getEmail());
        account.setName(oAuth2UserInfo.getName());
        account.setSurname(oAuth2UserInfo.getSurname());
        try {
            account.setPhoto(getBase64EncodedImage(oAuth2UserInfo.getImageUrl()));
        } catch (IOException ex) {
            account.setPhoto(null);
            ex.printStackTrace();
        }
        AccountWrapper accountWrapper = new AccountWrapper();
        accountWrapper.setUser(user);
        accountWrapper.setAccount(account);
        accountServiceClient.save(accountWrapper);
        return user;
    }

    public String getBase64EncodedImage(String imageURL) throws IOException {
        URL url = new URL(imageURL);
        InputStream is = url.openStream();
        byte[] bytes = org.apache.commons.io.IOUtils.toByteArray(is);
        return Base64.encodeBase64String(bytes);
    }
}
