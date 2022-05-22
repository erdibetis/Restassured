package petStore.controller;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import petStore.model.Pet;

import static io.restassured.RestAssured.given;

public class PetController {

    private String path = "/pet";

    protected Response getPet(int id, int statusCode){
        return  given()
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .get(path+"/"+id)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract().response();
    }

    protected Response postRequest(Pet body, int statusCode) {
        return  given()
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when()
                .post(path)
                .then()
                .log().all()
                .statusCode(statusCode).extract().response();
    }

    protected Response putPet(Object body, int statusCode){
        return  given()
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when()
                .put(path)
                .then()
                .log().all()
                .statusCode(statusCode).extract().response();
    }

    protected Response deletePet(int id, int statusCode){
        return  given()
                .contentType(ContentType.JSON)
                .when()
                .log().all()
                .delete(path+"/"+id)
                .then()
                .log().all()
                .statusCode(statusCode).extract().response();
    }

}
