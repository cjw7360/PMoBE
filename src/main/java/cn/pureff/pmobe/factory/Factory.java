package cn.pureff.pmobe.factory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("factory.infos")
public class Factory {
    @JsonProperty("_id")
    private ObjectId id;

    @Indexed(unique = true)
    private String name;
    private String description;

    private Date createdAt;
    private Date updatedAt;
}
