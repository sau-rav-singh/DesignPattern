package StrategyPattern;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Main {
    public static void main(String[] args) {
        Response validResponse = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

        ValidationStrategy validStrategy = new ValidResponseStrategy();
        ResponseValidatorContext context = new ResponseValidatorContext(validStrategy);
        context.validateResponse(validResponse);

        Response invalidResponse = RestAssured.get("https://jsonplaceholder.typicode.com/invalid");

        ValidationStrategy invalidStrategy = new InvalidResponseStrategy();
        context.setStrategy(invalidStrategy);
        context.validateResponse(invalidResponse);
        System.out.println("Test Passed");
    }
}
