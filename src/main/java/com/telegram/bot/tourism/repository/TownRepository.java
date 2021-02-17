package com.telegram.bot.tourism.repository;

import com.telegram.bot.tourism.model.Town;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TownRepository extends MongoRepository<Town, UUID> {

    Town findTownById(UUID id);

    Town findTownByName(String town);
}
