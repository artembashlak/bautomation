package com.waverley.testcases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginPageEndpointsPingTest {

    @Test
    public void loginPageIsAvailble() {
        given().when().get("https://waverleybooking.github.io").then().statusCode(200);
    }
}

