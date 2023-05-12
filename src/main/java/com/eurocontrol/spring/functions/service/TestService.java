package com.eurocontrol.spring.functions.service;

import com.eurocontrol.spring.functions.model.Test;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class TestService implements Function<String, Test> {

    private final Gson gson;

    @Override
    public Test apply(String message) {
        return gson.fromJson(message, Test.class);
    }
}
