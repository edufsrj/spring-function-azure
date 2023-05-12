package com.eurocontrol.spring.functions.service;

import com.eurocontrol.spring.functions.model.TestModel;
import com.google.gson.Gson;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@NoArgsConstructor
public class TestService implements Function<String, TestModel> {

    private final Gson gson = new Gson();

    @Override
    public TestModel apply(String message) {
        return gson.fromJson(message, TestModel.class);
    }
}
