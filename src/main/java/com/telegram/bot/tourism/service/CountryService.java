package com.telegram.bot.tourism.service;

import com.telegram.bot.tourism.model.Country;
import com.telegram.bot.tourism.model.dto.CountryDto;

public interface CountryService {

    CountryDto addNewCountry(Country newCountry);

    CountryDto deleteCountry(Country countryForDelete);

    CountryDto redactionCountry(Country countryForRedaction);

}
