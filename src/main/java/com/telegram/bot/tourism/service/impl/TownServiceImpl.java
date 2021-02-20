package com.telegram.bot.tourism.service.impl;


import com.telegram.bot.tourism.dto.TownDto;
import com.telegram.bot.tourism.exception.ResourceNotFoundException;
import com.telegram.bot.tourism.mappers.TownMapper;
import com.telegram.bot.tourism.model.Town;
import com.telegram.bot.tourism.repository.TownRepository;
import com.telegram.bot.tourism.service.TelegramBotService;
import com.telegram.bot.tourism.service.TownService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class TownServiceImpl implements TownService, TelegramBotService {

    private final TownRepository townRepository;
    private final TownMapper townMapper;

    @Override
    public TownDto addNewTown(TownDto newTown) {

        Town townForSave = townMapper.toTown(newTown);

        townRepository.save(townForSave);

        log.info("IN addNewTown - town: {} successfully added", townForSave);

        return newTown;
    }

    @Override
    public TownDto deleteTown(UUID id) {

        Town townFind = townRepository.findTownById(id);

        if(townFind == null){
            throw new ResourceNotFoundException("Town with id : " + id +" not found ");
        }

        townRepository.deleteById(townFind.getId());

        log.info("IN deleteTown - town: {} successfully deleted", townFind);

        return townMapper.toTownDto(townFind);
    }

    @Override
    public TownDto redactionTown(Town townForRedaction) {

        Town town = townRepository.findTownById(townForRedaction.getId());

        if(town == null){
            throw new ResourceNotFoundException
                    ("Town with id : " + townForRedaction.getId() + " not found");
        }

        townRepository.save(townForRedaction);

        log.info("IN redactionTown - town: {} successfully edited", townForRedaction);

        return townMapper.toTownDto(townForRedaction);
    }

    @Override
    public String getInformationAboutTown(String townName) {

        Town townFind = townRepository.findTownByName(townName);

        if(townFind == null) {
            return "Not found information about town : " + townName;
        }

        return townFind.getInformationAboutTown();
    }

}