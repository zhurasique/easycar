package com.easycar.base.service;

import com.easycar.base.entity.Color;
import com.easycar.base.exception.NoSuchElementFoundException;
import com.easycar.base.repository.ColorRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

public class ColorServiceTest {

    @InjectMocks
    private ColorService colorService;

    @Mock
    private ColorRepo colorRepo;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void shouldGetColorById() {
        final Color color = new Color();
        color.setId("test-id");
        color.setPattern("#000000");
        color.setColor("black");

        doReturn(Optional.of(color)).when(colorRepo).findById(color.getId());
        Color found = colorService.findById(color.getId());

        assertEquals(color, found);
    }

    @Test(expected = NoSuchElementFoundException.class)
    public void shouldFailNotFound() {
        colorService.findById("fail");
    }
}
