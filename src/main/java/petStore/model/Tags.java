package petStore.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Tags {

    private int id;
    private String name;

    public Tags() {

    }
    public Tags(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}