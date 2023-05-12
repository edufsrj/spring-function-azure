package com.eurocontrol.spring.functions;

import com.eurocontrol.spring.functions.model.TestModel;
import com.eurocontrol.spring.functions.service.TestService;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */

public class HttpTriggerHandler extends FunctionInvoker<String, TestModel> {

    private final TestService service;

    public HttpTriggerHandler() {
        this.service = new TestService();
    }

    @FunctionName("spring-test")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req",
                    methods = {HttpMethod.POST},
                    authLevel = AuthorizationLevel.FUNCTION) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");
        var message = request.getBody().orElse("");
        var test = service.apply(message);
        return request.createResponseBuilder(HttpStatus.OK).body(test).build();
    }
}
