package petStore.RestAssured;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import petStore.controller.PetController;

public class BaseTest extends PetController {

    @BeforeClass
    public void init(){
        RestAssured.baseURI= "https://petstore.swagger.io/v2";
    }
}
