package org.naic.tests.restapi;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class PetStoreTest {

    @Test
    public void ensurePetStoreUpTest(){
        given().when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=available").then().statusCode(200);
    }

    @Test
    public void ensureMultiplePetsAreAvailable(){
        get("https://petstore.swagger.io/v2/pet/findByStatus?status=available").then().statusCode(200);
        List<String> pets = get("https://petstore.swagger.io/v2/pet/findByStatus?status=available").path("pets");
        Assert.assertTrue(pets.size() > 1);
    }
}
