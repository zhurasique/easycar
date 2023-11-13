package com.easycar.advert.service;

import com.easycar.common.exception.BusinessLogicException;
import com.easycar.common.exception.NoSuchElementFoundException;
import com.easycar.advert.entity.Advert;
import com.easycar.advert.entity.Exchange;
import com.easycar.advert.repository.ExchangeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepo exchangeRepo;
    private final AdvertService advertService;

    public Exchange findById(String id) {
        return exchangeRepo.findById(id).orElseThrow(() -> new NoSuchElementFoundException(id));
    }

    public List<Exchange> findByToAdvertId(String id) {
        return exchangeRepo.findByToAdvertId(id);
    }

    public Exchange update(String id, Exchange.Surcharge surcharge) {
        Exchange oldData = findById(id);
        oldData.setSurcharge(surcharge);
        return exchangeRepo.save(oldData);
    }

    public void delete(String id) {
        exchangeRepo.delete(findById(id));
    }

    public Exchange save(Exchange exchange) {
        Advert fromAdvert = exchange.getFromAdvert();
        Advert toAdvert = exchange.getToAdvert();
        if (fromAdvert.getId().equals(toAdvert.getId())) {
            throw new BusinessLogicException("Exchange cannot be created for itself");
        }
        exchange.setFromAdvert(advertService.findById(exchange.getFromAdvert().getId()));
        exchange.setToAdvert(advertService.findById(exchange.getToAdvert().getId()));
        return exchangeRepo.save(exchange);
    }
}
