package com.telegram.bot.tourism.service;

import com.telegram.bot.tourism.model.Town;
import com.telegram.bot.tourism.model.dto.TownDto;

public interface TownService {

    TownDto addNewTown(Town newTown);

    TownDto deleteTown(Town townForDelete);

    TownDto redactionTown(Town townForRedaction);

}
