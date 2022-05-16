package com.service.advert.repository;

import com.service.advert.entity.Exchange;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExchangeRepo extends MongoRepository<Exchange, String> {
    List<Exchange> findByToAdvertId(String id);
}
