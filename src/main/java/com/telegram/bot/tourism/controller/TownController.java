package com.telegram.bot.tourism.controller;

import com.telegram.bot.tourism.model.Town;
import com.telegram.bot.tourism.dto.TownDto;
import com.telegram.bot.tourism.service.TownService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequestMapping("town")
@RequiredArgsConstructor
@Slf4j
public class TownController {

    private final TownService townService;

    @PostMapping
    public TownDto addNewTownInDatabase(@Valid @RequestBody TownDto townDto){
        log.info("Add new town in database : {} ",townDto);
        return townService.addNewTown(townDto);
    }

    @DeleteMapping
    public TownDto deleteTownInDatabase(@NotNull @RequestParam("townId") UUID townId){
        log.info("Delete town with id : {} in database",townId);
        return townService.deleteTown(townId);
    }

    @PutMapping
    public TownDto editTownInDatabase(@Valid @RequestBody Town town){
        log.info("Edit town with id : {} in database",town.getId());
        return townService.redactionTown(town);
    }

}