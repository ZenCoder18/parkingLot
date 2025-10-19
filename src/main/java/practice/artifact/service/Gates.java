package practice.artifact.service;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import practice.artifact.models.ParkingSpace;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@SuperBuilder
public abstract class Gates {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private Integer id = COUNTER.incrementAndGet();
    private String name;
    private Integer row;
    private Integer col;
    private ParkingLot parkingLot;

    public int getDistanceFromSpace(ParkingSpace space) {
        return Math.abs(row-space.getRow()) + Math.abs(col-space.getCol());
    }
}
