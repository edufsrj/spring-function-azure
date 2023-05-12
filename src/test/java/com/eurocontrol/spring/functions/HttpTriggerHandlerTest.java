package com.eurocontrol.spring.functions;

import com.eurocontrol.spring.functions.model.TestModel;
import com.eurocontrol.spring.functions.service.TestService;
import com.microsoft.azure.functions.ExecutionContext;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;


public class HttpTriggerHandlerTest {

    private final String FAKE_JSON = """
            {
                "id": "11b44a1b-8d1f-4ab2-9d11-51ab4725941e",
                "test": "Teste!!!",
                "now": "2023-05-12T15:08:55+00:00"
            }
            """;

    @Test
    public void test() {
        var result = new TestService().apply(FAKE_JSON);
        assertThat(result.getId()).isEqualTo("11b44a1b-8d1f-4ab2-9d11-51ab4725941e");
    }

    @Test
    public void start() {
        FunctionInvoker<String, TestModel> handler = new FunctionInvoker<>(
                TestService.class);
        var result = handler.handleRequest(FAKE_JSON, new ExecutionContext() {
            @Override
            public Logger getLogger() {
                return Logger.getLogger(HttpTriggerHandlerTest.class.getName());
            }

            @Override
            public String getInvocationId() {
                return "id1";
            }

            @Override
            public String getFunctionName() {
                return "spring-test";
            }
        });
        handler.close();
        assertThat(result.getTest()).isEqualTo("Teste!!!");
    }
}
