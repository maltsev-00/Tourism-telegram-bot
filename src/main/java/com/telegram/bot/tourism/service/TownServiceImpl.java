package com.telegram.bot.tourism.service;


import com.telegram.bot.tourism.mappers.TownMapper;
import com.telegram.bot.tourism.model.Town;
import com.telegram.bot.tourism.model.dto.TownDto;
import com.telegram.bot.tourism.repository.TownRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;


@Service
@Data
@Slf4j
public class TownServiceImpl implements TownService, TelegramBotService {

    private final TownRepository townRepository;
    private final TownMapper townMapper;

    @Override
    public TownDto addNewTown(TownDto newTown) {

        if(townRepository.findTownByName(newTown.getName()) == null){

            Town town = townMapper.toTown(newTown);
            town.setId(UUID.randomUUID());

            return townMapper.toTownDto(townRepository.save(town));
        }

        throw new ResponseStatusException
                (HttpStatus.BAD_REQUEST,"Town with name : "+ newTown.getName()
                        +" was founded in database");
    }

    @Override
    public TownDto deleteTown(UUID id) {

        Town townFind = townRepository.findTownById(id);

        if(townFind == null){
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND,"City ID not found : "+ id);
        }

        townRepository.delete(townFind);

        return townMapper.toTownDto(townFind);
    }

    @Override
    public TownDto redactionTown(Town townForRedaction) {

        Town townFind = townRepository.findTownById(townForRedaction.getId());

        if(townFind == null){
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND,"City ID not found : "+ townForRedaction.getId());
        }
        return townMapper
                .toTownDto(townRepository.save(townForRedaction));

    }

    @Override
    public String getInformationAboutTown(String country) {

        Town townFind = townRepository.findTownByName(country);

        if(townFind == null) {
            return "Not found information about city : "+country;
        }

        return townFind.getInformationAboutCountry();
    }

}
