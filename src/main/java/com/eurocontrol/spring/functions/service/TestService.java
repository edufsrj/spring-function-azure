package com.eurocontrol.spring.functions.service;

import com.eurocontrol.spring.functions.model.Test;
import com.google.gson.Gson;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@NoArgsConstructor
public class TestService implements Function<String, Test> {

    private final Gson gson = new Gson();

    @Override
    public Test apply(String message) {
        return gson.fromJson(message, Test.class);
    }
}
