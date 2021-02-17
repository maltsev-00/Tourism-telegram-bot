package com.telegram.bot.tourism.repository;

import com.telegram.bot.tourism.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CountryRepository extends MongoRepository<Country, UUID> {

    Country findCountryById(UUID id);

    Country findByName(String country);
}
