package com.telegram.bot.tourism.repository;

import com.telegram.bot.tourism.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

    Town findTownByIdAndName(Long id,String nameTown);

    Town findTownByName(String town);

    Town findTownById(Long id);

}
