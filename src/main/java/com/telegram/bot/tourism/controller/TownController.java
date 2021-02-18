package com.telegram.bot.tourism.controller;

import com.telegram.bot.tourism.model.Town;
import com.telegram.bot.tourism.model.dto.TownDto;
import com.telegram.bot.tourism.service.TownService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("town")
@RequiredArgsConstructor
@Slf4j
public class TownController {

    private final TownService townService;

    @PostMapping
    public TownDto addNewTownInDatabase(@Valid @RequestBody TownDto townDto){
        log.info("Add new town in database : " + townDto.toString());
        return townService.addNewTown(townDto);
    }

    @DeleteMapping
    public TownDto deleteTownInDatabase(@RequestParam UUID townId){
        log.info("Delete town in database by ID : " + townId);
        return townService.deleteTown(townId);
    }

    @PutMapping
    public TownDto changeTownInDatabase(@Valid @RequestBody Town town){
        log.info("Redaction town in database : " + town.toString());
        return townService.redactionTown(town);
    }

}
