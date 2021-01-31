package com.service.base.service;

import com.service.base.model.Transmission;
import com.service.base.repository.TransmissionRepo;
import com.service.base.util.ErrorLogUtil;
import com.service.base.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransmissionService {

    private final TransmissionRepo transmissionRepo;

    public TransmissionService(TransmissionRepo transmissionRepo) {
        this.transmissionRepo = transmissionRepo;
    }

    public List<Transmission> findAll() {
        return transmissionRepo.findAll();
    }

    public ResponseEntity<?> save(Transmission transmission) {

        if(!ValidationUtil.validateTransmission(transmission.getName(), transmissionRepo))
            return new ResponseEntity<>(ErrorLogUtil.showError(119), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(transmissionRepo.save(transmission), HttpStatus.OK);
    }
}
