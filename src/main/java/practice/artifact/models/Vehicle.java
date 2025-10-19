package practice.artifact.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Vehicle {
    private Integer id;
    private String number;
    private String color;
    private Integer user_id;
}
