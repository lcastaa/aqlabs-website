package aqlabs.app.website.models;

// This Class represents a Contact from request

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactForm {

    @JsonProperty("name")
    String name;

    @JsonProperty("email")
    String email;

    @JsonProperty("message")
    String message;

}
