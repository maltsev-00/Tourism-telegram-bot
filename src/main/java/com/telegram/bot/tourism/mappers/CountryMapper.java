package com.telegram.bot.tourism.mappers;

import com.telegram.bot.tourism.model.Country;
import com.telegram.bot.tourism.model.dto.CountryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryDto toCountryDto(Country country);

}
