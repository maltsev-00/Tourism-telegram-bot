package com.telegram.bot.tourism.controller;


import com.github.kshashov.telegram.api.TelegramMvcController;
import com.github.kshashov.telegram.api.bind.annotation.BotController;
import com.github.kshashov.telegram.api.bind.annotation.BotPathVariable;
import com.github.kshashov.telegram.api.bind.annotation.request.MessageRequest;

import com.telegram.bot.tourism.config.TelegramConfig;
import com.telegram.bot.tourism.service.TelegramBotService;
import lombok.RequiredArgsConstructor;


@BotController
@RequiredArgsConstructor
public class TelegramController extends TelegramConfig {

    private final TelegramBotService telegramBotService;

    @MessageRequest("{country}")
    public String getInfoAboutCountry(@BotPathVariable("country") String country) {
        return telegramBotService.getCountry(country);
    }

}
