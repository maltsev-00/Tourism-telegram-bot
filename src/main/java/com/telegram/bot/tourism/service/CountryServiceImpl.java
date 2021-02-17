package com.telegram.bot.tourism.service;


import com.telegram.bot.tourism.exception.CountryNotFoundException;
import com.telegram.bot.tourism.mappers.CountryMapper;
import com.telegram.bot.tourism.model.Country;
import com.telegram.bot.tourism.model.dto.CountryDto;
import com.telegram.bot.tourism.repository.CountryRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Data
@Slf4j
public class CountryServiceImpl implements CountryService, TelegramBotService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public CountryDto addNewCountry(Country newCountry) {
        return countryMapper.toCountryDto(countryRepository.save(newCountry));
    }

    @Override
    public CountryDto deleteCountry(Country countryForDelete) {

        Country countryFind = countryRepository.findCountryById(countryForDelete.getId());

        if(countryFind==null){
            throw new CountryNotFoundException
                    ("Not found id : "+countryForDelete.getId());
        }
        countryRepository.deleteById(countryFind.getId());

        return countryMapper.toCountryDto(countryForDelete);
    }

    @Override
    public CountryDto redactionCountry(Country countryForRedaction) {

        Country countryFind = countryRepository.findCountryById(countryForRedaction.getId());

        if(countryFind==null){
            throw new CountryNotFoundException
                    ("Not found id : "+countryForRedaction.getId());
        }
        return countryMapper
                .toCountryDto(countryRepository.save(countryForRedaction));

    }

    @Override
    public String getInformationAboutCountry(String country) {

        Country countryFind = countryRepository.findCountryByName(country);

        if(countryFind!=null)
            return countryFind.getInformationAboutCountry();
        else
            return country+" not found, please try again ";
    }

}
