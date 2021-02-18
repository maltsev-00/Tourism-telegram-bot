package com.telegram.bot.tourism.mappers;

import com.telegram.bot.tourism.model.Town;
import com.telegram.bot.tourism.model.dto.TownDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TownMapper {

    TownDto toTownDto(Town town);

    Town toTown(TownDto town);

}
