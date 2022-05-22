package petStore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter
@Setter
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {

    @JsonProperty("id")
    private int id;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private String[] photoUrls;
    @JsonProperty("tags")
    private Tags[] tags;
    @JsonProperty("status")
    private String status;

    public Pet() {

    }

    public Pet(int id, Category category, String name, String[] photoUrls, Tags[] tags, String status) {
        super();
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }


}
