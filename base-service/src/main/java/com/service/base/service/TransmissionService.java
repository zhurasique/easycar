package com.service.base.service;

import com.service.base.entity.Transmission;
import com.service.base.repository.TransmissionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransmissionService {

    private final TransmissionRepo transmissionRepo;

    public List<Transmission> findAll() {
        return transmissionRepo.findAll();
    }

    public Transmission save(Transmission transmission) {
        return transmissionRepo.save(transmission);
    }
}
