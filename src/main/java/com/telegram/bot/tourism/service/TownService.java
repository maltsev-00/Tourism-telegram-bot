package com.telegram.bot.tourism.service;

import com.telegram.bot.tourism.model.Town;
import com.telegram.bot.tourism.model.dto.TownDto;


public interface TownService {

    TownDto addNewTown(TownDto newTown);

    TownDto deleteTown(Long id);

    TownDto redactionTown(Town townForRedaction);

}
