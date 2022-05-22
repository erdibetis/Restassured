package petStore.RestAssured;

import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import petStore.builder.PetCreateBuilder;
import petStore.model.Pet;
import petStore.model.PetNegativeResponse;


import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PetTestCase extends BaseTest {

    @Test()
    public void petCreate(){

        Pet createPet = postRequest(PetCreateBuilder.petCreateData(), HttpStatus.SC_OK).as(Pet.class);

        assertEquals(PetCreateBuilder.petCreateData().getId(), createPet.getId());
        assertEquals(PetCreateBuilder.petCreateData().getName(), createPet.getName());
        assertEquals(PetCreateBuilder.petCreateData().getStatus(), createPet.getStatus());
        assertEquals(PetCreateBuilder.petCreateData().getCategory().getId(), createPet.getCategory().getId());
        assertEquals(PetCreateBuilder.petCreateData().getCategory().getName(), createPet.getCategory().getName());

    }
    @Test()
    public void getPetId(){

        Pet createPet = postRequest(PetCreateBuilder.petCreateData(), HttpStatus.SC_OK).as(Pet.class);
        Pet responsePet = getPet(createPet.getId(), HttpStatus.SC_OK).as(Pet.class);
        assertEquals(createPet.getId(), responsePet.getId());
    }

    @Test()
    public void updatePet(){
        Pet createPet = postRequest(PetCreateBuilder.petCreateData(), HttpStatus.SC_OK).as(Pet.class);
        Pet update = putPet(PetCreateBuilder.petUpdateData(), HttpStatus.SC_OK).as(Pet.class);
        assertNotEquals(createPet.getId(), update.getId());
        assertNotEquals(createPet.getName(), update.getName());
    }

    @Test()
    public void deletePet(){
        Integer petId = postRequest(PetCreateBuilder.petCreateData(), HttpStatus.SC_OK).as(Pet.class).getId();
        PetNegativeResponse delete = deletePet(petId, HttpStatus.SC_OK).as(PetNegativeResponse.class);
        assertEquals("200",delete.getCode());
        assertEquals(petId.toString(),delete.getMessage());
    }

    @Description("negative test case")
    @Test()
    public void notfoundForGetRequest(){

        int randomId = ThreadLocalRandom.current().nextInt(1000, 999999);
        PetNegativeResponse responsePet = getPet(randomId, HttpStatus.SC_NOT_FOUND).as(PetNegativeResponse.class);

        assertEquals("1",responsePet.getCode());
        assertEquals("error",responsePet.getType());
        assertEquals("Pet not found",responsePet.getMessage());
    }

    @Description("negative test case")
    @Test()
    public void notfoundForDeleteRequest(){

        int randomId = ThreadLocalRandom.current().nextInt(1000, 999999);
        deletePet(randomId, HttpStatus.SC_NOT_FOUND);

    }

}
