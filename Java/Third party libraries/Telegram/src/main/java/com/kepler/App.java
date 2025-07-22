package com.kepler;

import com.kepler.service.TelegramBotService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws TelegramApiException {
        var context = SpringApplication.run(App.class, args);

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        TelegramBotService bot = context.getBean(TelegramBotService.class);
        botsApi.registerBot(bot);
    }
}
