package petStore.builder;

import petStore.model.Category;

public class CategoryBuilder {

    public static Category category(){
        return Category.builder()
                .id(1)
                .name("Category 1")
                .build();
    }
}
