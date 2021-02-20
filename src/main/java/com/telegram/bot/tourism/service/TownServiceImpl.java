package com.telegram.bot.tourism.service;


import com.telegram.bot.tourism.mappers.TownMapper;
import com.telegram.bot.tourism.model.Town;
import com.telegram.bot.tourism.model.dto.TownDto;
import com.telegram.bot.tourism.repository.TownRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class TownServiceImpl implements TownService, TelegramBotService {

    private final TownRepository townRepository;
    private final TownMapper townMapper;

    @Override
    public TownDto addNewTown(TownDto newTown) {

        if(townRepository.findTownByName(newTown.getName()) != null){

            throw new ResponseStatusException
                    (HttpStatus.BAD_REQUEST,"Town with name : "+ newTown.getName()
                            +" was founded in database");
        }

        townRepository.save(townMapper.toTown(newTown));

        return newTown;
    }

    @Override
    public TownDto deleteTown(UUID id) {

        Town townFind = townRepository.findTownById(id);

        if(townFind == null){
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND,"City ID not found : "+ id);
        }

        townRepository.deleteById(townFind.getId());

        return townMapper.toTownDto(townFind);
    }

    @Override
    public TownDto redactionTown(Town townForRedaction) {

        if(townRepository.findTownById(townForRedaction.getId()) == null){
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND,"City ID not found : "+ townForRedaction.getId());
        }

        townRepository.save(townForRedaction);

        return townMapper.toTownDto(townForRedaction);

    }

    @Override
    public String getInformationAboutTown(String city) {

        Town townFind = townRepository.findTownByName(city);

        if(townFind == null) {
            return "Not found information about city : "+city;
        }

        return townFind.getInformationAboutCity();
    }

}
