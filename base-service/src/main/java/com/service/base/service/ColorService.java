package com.service.base.service;

import com.service.base.entity.Color;
import com.service.base.repository.ColorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorService {

    private final ColorRepo colorRepo;

    public List<Color> findAll() {
        return colorRepo.findAll();
    }

    public Color save(Color color) {
        return colorRepo.save(color);
    }
}
