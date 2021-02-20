package com.telegram.bot.tourism.repository;

import com.telegram.bot.tourism.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface TownRepository extends JpaRepository<Town, UUID> {

    Town findTownByName(String nameTown);

    Town findTownById(UUID id);

    Town findTownByIdAndName(UUID id,String nameTown);
}
