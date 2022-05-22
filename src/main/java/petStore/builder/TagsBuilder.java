package petStore.builder;

import petStore.model.Tags;

public class TagsBuilder {

    public static Tags tagsList(){
        return Tags.builder()
                .id(1)
                .name("Dog")
                .build();

    }

    public static Tags tagsList2(){
        return Tags.builder()
                .id(2)
                .name("Cat")
                .build();

    }
}
