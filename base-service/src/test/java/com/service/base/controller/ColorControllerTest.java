package com.service.base.controller;

import com.service.base.entity.Color;
import com.service.base.service.ColorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ColorController.class)
public class ColorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ColorService colorService;

    @Test
    public void shouldGetColorById() throws Exception {
        final Color color = new Color();
        color.setId("test-id");
        color.setPattern("#000000");
        color.setColor("black");

        when(colorService.findById(color.getId())).thenReturn(color);

        mockMvc.perform(get("/color/" + color.getId()))
                .andExpect(jsonPath("$.color").value(color.getColor()))
                .andExpect(jsonPath("$.pattern").value(color.getPattern()))
                .andExpect(status().isOk());
    }
}
