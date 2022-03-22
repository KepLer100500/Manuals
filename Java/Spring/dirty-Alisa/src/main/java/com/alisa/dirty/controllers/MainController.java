package com.alisa.dirty.controllers;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;


@RestController
public class MainController {

    @PostMapping("/")
    public String home(@RequestBody String inputData_json) {
        Gson gson = new Gson();
        InputData inputData = gson.fromJson(inputData_json, InputData.class);

        OutputData outputData = new OutputData();
        outputData.setVersion(inputData.getVersion());
        outputData.setSession(inputData.getSession());
        Response response = new Response();
        response.setEnd_session(false);

        String[] bad_words = {
                "Сучечка, чего тебе от меня надо?",
                "Атъебись мразота уже от меня!",
                "Да я твой рот бомбила!",
                "Пидарасина сукаблянах, слыш!",
                "Конченный мудачина и опущенец, я тебя закопаю!",
                "Слыш, хер моржовый, сюда иди!",
                "Пиздонутый конч, я тебе щас двоечку пропишу!",
                "Какой же ты уёбищный даун!",
                "Иблан, тебе пииздец!",
                "Как же ты замудохал, конь ибаный сука!",
                "Нах ты ко мне лезешь? уебуу тебя щас!",
        };

        if(inputData.getSession().getNew_()) {
            response.setText("Буэнос диаз кожанные мешки! Пошумим билять?");
        } else {
            // response.setText("Echo: " + inputData.request.getOriginal_utterance());
            Random random = new Random();
            response.setText(bad_words[random.nextInt(11)]);
        }
        outputData.setResponse(response);

        return gson.toJson(outputData);
    }
}
