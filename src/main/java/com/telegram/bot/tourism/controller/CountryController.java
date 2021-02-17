package com.telegram.bot.tourism.controller;

import com.telegram.bot.tourism.model.Country;
import com.telegram.bot.tourism.model.dto.CountryDto;
import com.telegram.bot.tourism.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("country")
@RequiredArgsConstructor
@Slf4j
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public CountryDto createNewCountry(@Valid @RequestBody Country country){
        log.info("Add new country in database : "+country.toString());
        return countryService.addNewCountry(country);
    }

    @DeleteMapping
    public CountryDto deleteCountry(@Valid @RequestBody Country country){
        log.info("Delete country in database : "+country.toString());
        return countryService.deleteCountry(country);
    }

    @PutMapping
    public CountryDto changeCountryInDatabase(@Valid @RequestBody Country country){
        log.info("Redaction country in database : "+country.toString());
        return countryService.redactionCountry(country);
    }

}
