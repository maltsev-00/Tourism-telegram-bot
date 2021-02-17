package com.telegram.bot.tourism.controller;

import com.telegram.bot.tourism.model.Town;
import com.telegram.bot.tourism.model.dto.TownDto;
import com.telegram.bot.tourism.service.TownService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("town")
@RequiredArgsConstructor
@Slf4j
public class TownController {

    private final TownService townService;

    @PostMapping
    public TownDto createNewTown(@Valid @RequestBody Town town){
        log.info("Add new town in database : "+ town.toString());
        return townService.addNewTown(town);
    }

    @DeleteMapping
    public TownDto deleteTownInDatabase(@Valid @RequestBody Town town){
        log.info("Delete country in database : "+ town.toString());
        return townService.deleteTown(town);
    }

    @PutMapping
    public TownDto changeTownInDatabase(@Valid @RequestBody Town town){
        log.info("Redaction town in database : "+ town.toString());
        return townService.redactionTown(town);
    }

}
