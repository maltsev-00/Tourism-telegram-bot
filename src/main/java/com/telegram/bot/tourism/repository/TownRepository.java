package com.telegram.bot.tourism.repository;

import com.telegram.bot.tourism.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

    Town findTownById(Long id);

    Town findTownByName(String town);

}
