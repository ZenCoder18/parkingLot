package practice.artifact.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class User {
    private Integer id;
    private Integer phone_no;
    private List<Vehicle> vehicleList = new ArrayList<>();
}
