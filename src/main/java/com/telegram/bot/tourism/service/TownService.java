package com.telegram.bot.tourism.service;

import com.telegram.bot.tourism.model.Town;
import com.telegram.bot.tourism.dto.TownDto;

import java.util.UUID;


public interface TownService {

    TownDto addNewTown(TownDto newTown);

    TownDto deleteTown(UUID id);

    TownDto redactionTown(Town townForRedaction);

}
