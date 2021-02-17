package com.telegram.bot.tourism.config;

import com.github.kshashov.telegram.api.TelegramMvcController;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties("telegram")
public class TelegramConfig implements TelegramMvcController {

    private String botToken;

    @Override
    public String getToken() {
        return botToken;
    }

}
