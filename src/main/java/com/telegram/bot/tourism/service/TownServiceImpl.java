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
    public TownDto deleteTown(Long id) {

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

       if(townRepository.findTownById(townForRedaction.getId()) == null){
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND,"City ID not found : "+ townForRedaction.getId());
        }
        
        return townMapper
                .toTownDto(townRepository.save(townForRedaction));

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
