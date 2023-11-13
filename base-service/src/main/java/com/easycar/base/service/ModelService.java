package com.easycar.base.service;

import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.base.entity.Model;
import com.easycar.base.repository.ModelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelRepo modelRepo;
    private final BrandService brandService;

    public List<Model> findAll(){
        return modelRepo.findAll();
    }

    public Model findById(String id) {
        return modelRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public Model save(Model model) {
        model.setBrand(brandService.findById(model.getBrand().getId()));
        return modelRepo.save(model);
    }
}
