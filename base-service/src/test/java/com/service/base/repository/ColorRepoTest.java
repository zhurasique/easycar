package com.service.base.repository;

import com.service.base.entity.Color;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@DataMongoTest
@RunWith(SpringRunner.class)
public class ColorRepoTest {
    @Autowired
    private ColorRepo colorRepo;

    @Test
    public void shouldFindColorById() {
        Color color = setUpColor();
        colorRepo.save(color);

        Color found = colorRepo.findById(color.getId()).get();
        assertEquals(color.getColor(), found.getColor());
        assertEquals(color.getPattern(), found.getPattern());
    }

    private Color setUpColor() {
        final Color color = new Color();
        color.setId("test-id");
        color.setPattern("#000000");
        color.setColor("black");
        return color;
    }
}
