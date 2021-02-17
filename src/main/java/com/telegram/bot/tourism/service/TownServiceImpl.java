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


@Service
@Data
@Slf4j
public class TownServiceImpl implements TownService, TelegramBotService {

    private final TownRepository townRepository;
    private final TownMapper townMapper;

    @Override
    public TownDto addNewTown(Town newTown) {

        Town townFind = townRepository.findTownByName(newTown.getName());

        if(townFind ==null){
            return townMapper.toTownDto(townRepository.save(newTown));
        }

        throw new ResponseStatusException
                (HttpStatus.BAD_REQUEST,"Town with name : "+ townFind.getName()+" was founded ");
    }

    @Override
    public TownDto deleteTown(Town townForDelete) {

        Town townFind = townRepository.findTownById(townForDelete.getId());

        if(townFind ==null){
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND,"Not found id town : "+ townForDelete.getId());
        }

        townRepository.deleteById(townFind.getId());

        return townMapper.toTownDto(townForDelete);
    }

    @Override
    public TownDto redactionTown(Town townForRedaction) {

        Town townFind = townRepository.findTownById(townForRedaction.getId());

        if(townFind ==null){
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND,"Not found id town : "+ townForRedaction.getId());
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
