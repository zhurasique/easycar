package com.easycar.advert.controller;

import com.easycar.advert.entity.Exchange;
import com.easycar.advert.entity.validation.SurchargeConstraint;
import com.easycar.advert.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("api/advert-service/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("{id}")
    public Exchange findById(@PathVariable String id) {
        return exchangeService.findById(id);
    }

    @GetMapping("/to-advert/{id}")
    public List<Exchange> findByToAdvertId(@PathVariable String id){
        return exchangeService.findByToAdvertId(id);
    }

    @PatchMapping("{id}")
    public Exchange update(@PathVariable String id,
                           @SurchargeConstraint @RequestBody Exchange.Surcharge surcharge) {
        return exchangeService.update(id, surcharge);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        exchangeService.delete(id);
    }

    @PostMapping
    public Exchange save(@Valid @RequestBody Exchange exchange) {
        return exchangeService.save(exchange);
    }
}
