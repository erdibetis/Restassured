package petStore.model;

import lombok.*;

@Data
@Getter
@Setter
@Builder
public class Category {

    private int id;
    private String name;

    public Category() {
    }

    public Category(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
