package practice.artifact.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.artifact.enums.ParkingStatus;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingSpace {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private Integer id = COUNTER.incrementAndGet();
    private Integer row;
    private Integer col;
    private ParkingStatus status;
    private Vehicle vehicle;
    private Boolean active;

    @Override
    public String toString() {
        return "Parking Space : "+row +"|"+col;
    }
}
