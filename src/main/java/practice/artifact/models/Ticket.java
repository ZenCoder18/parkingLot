package practice.artifact.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Ticket {
    private Integer id;
    private LocalDateTime bookedTime;
    private ParkingSpace parkingSpace;
    private Vehicle vehicle;
}
