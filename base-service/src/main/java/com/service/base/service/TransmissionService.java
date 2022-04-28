package com.service.base.service;

import com.service.base.entity.Transmission;
import com.service.base.repository.TransmissionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransmissionService {

    private final TransmissionRepo transmissionRepo;

    public List<Transmission> findAll() {
        return transmissionRepo.findAll();
    }

    public ResponseEntity<?> save(Transmission transmission) {
        return new ResponseEntity<>(transmissionRepo.save(transmission), HttpStatus.OK);
    }
}
