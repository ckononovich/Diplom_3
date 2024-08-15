package model;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseHttpClient {
    public static RequestSpecification baseRequestSpec() {
        return new RequestSpecBuilder().setBaseUri("https://stellarburgers.nomoreparties.site")
                .addHeader("Content-type", "application/json")
                .setRelaxedHTTPSValidation()
                .build();
    }

    public static RequestSpecification baseRequestSpecWithToken(String token) {
        return new RequestSpecBuilder().setBaseUri("https://stellarburgers.nomoreparties.site")
                .addHeader("Authorization", token)
                .addHeader("Content-type", "application/json")
                .setRelaxedHTTPSValidation()
                .build();
    }
}
