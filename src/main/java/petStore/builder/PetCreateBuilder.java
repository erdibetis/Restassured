package petStore.builder;

import petStore.model.Category;
import petStore.model.Pet;
import petStore.model.Tags;

public class PetCreateBuilder {

    //pet olusturmak icin
    public static Pet petCreateData() {
        ;
        return Pet.builder()
                .id(19071907)
                .name("Dog")
                .category(new Category(1, "hav hav"))
                .photoUrls(new String[]{"https://www.youtube.com/watch?v=5wzntE1XNrs"})
                .tags(new Tags[]{new Tags(0, "animal"), new Tags(1, "pet"), new Tags(2, "dog")})
                .status("available")
                .build();
    }

    //pet update icin
    //id ler petCreateData datası ile ayni olamlidir
    public static Object petUpdateData() {
        Pet creatData = Pet.builder()
                .id(34534533)
                .name("Dog Update")
                .category(new Category(1, "hav hav update"))
                .photoUrls(new String[]{"https://www.youtube.com/watch?v=5wzntE1XNrs"})
                .tags(new Tags[]{new Tags(0, "animal"), new Tags(1, "pet update"), new Tags(2, "dog update")})
                .status("available")
                .build();
        return creatData;
    }
}
