package com.easycar.advert.controller;

import com.easycar.advert.entity.Advert;
import com.easycar.advert.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/advert-service/advert")
public class AdvertController {

    public final AdvertService advertService;

    @GetMapping
    public List<Advert> findAll() {
        return advertService.findAll();
    }

    @GetMapping("/paging")
    public Page<Advert> findAllPaging(@RequestParam int page,
                                      @RequestParam int size) {
        return advertService.findAllPaging(size, page);
    }

    @GetMapping("/sort")
    public List<Advert> findAllSorted(@RequestParam Sort.Direction direction,
                                      @RequestParam String property) {
        return advertService.findAllSorted(direction, property);
    }

    @GetMapping("{id}")
    public Advert findById(@PathVariable String id) {
        return advertService.findById(id);
    }

    @PatchMapping("/archive/{id}")
    public Advert archive(@PathVariable String id) {
        return advertService.archive(id);
    }

    @PutMapping("{id}")
    public Advert update(@PathVariable String id,
                         @Valid @RequestBody Advert newData) {
        return advertService.update(id, newData);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        advertService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Advert save(@Valid @RequestBody Advert advert) {
        return advertService.save(advert);
    }
}
