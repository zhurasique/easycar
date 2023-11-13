package com.easycar.base.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.easycar.base.entity.Color;
import com.easycar.base.service.ColorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ColorController.class)
public class ColorControllerTest {

    private static final String BASE_ENDPOINT = "/api/base-service/color";
    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ColorService colorService;

    @Test
    public void shouldGetListOfColors() throws Exception {
        final Color color = setUpColor();

        when(colorService.findAll()).thenReturn(ImmutableList.of(color));

        mockMvc.perform(get(BASE_ENDPOINT))
                .andExpect(jsonPath("$[0].color").value(color.getColor()))
                .andExpect(jsonPath("$[0].pattern").value(color.getPattern()))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetColorById() throws Exception {
        final Color color = setUpColor();

        when(colorService.findById(color.getId())).thenReturn(color);

        mockMvc.perform(get(BASE_ENDPOINT + "/" + color.getId()))
                .andExpect(jsonPath("$.color").value(color.getColor()))
                .andExpect(jsonPath("$.pattern").value(color.getPattern()))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldSaveColor() throws Exception {
        final Color color = setUpColor();

        String json = mapper.writeValueAsString(color);
        mockMvc.perform(post(BASE_ENDPOINT).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldFailValidation() throws Exception {
        final Color color = new Color();

        String json = mapper.writeValueAsString(color);
        mockMvc.perform(post(BASE_ENDPOINT).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
    }

    private Color setUpColor() {
        final Color color = new Color();
        color.setId("test-id");
        color.setPattern("#000000");
        color.setColor("black");
        return color;
    }
}
