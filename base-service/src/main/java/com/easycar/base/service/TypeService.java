package com.easycar.base.service;

import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.base.client.ImageServiceClient;
import com.easycar.base.entity.Type;
import com.easycar.base.repository.TypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeService {

    private final ImageServiceClient imageServiceClient;
    private final TypeRepo typeRepo;

    public List<Type> findAll() {
        return typeRepo.findAll();
    }

    public Type findById(String id) {
        return typeRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    @Transactional
    public Type save(Type.Dto typeDto) throws IOException {
        return typeRepo.save(Type.builder()
                .name(typeDto.getName())
                .image(imageServiceClient.save(typeDto.getImage().getBytes()))
                .build());
    }
}
