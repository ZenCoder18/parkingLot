package practice.artifact.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import practice.artifact.enums.ParkingStatus;
import practice.artifact.models.ParkingSpace;
import practice.artifact.strategy.FetchParkingSpace;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class ParkingLot {
    private Set<ParkingSpace> available = new HashSet<>();
    private Set<ParkingSpace> occupied = new HashSet<>();
    private Set<Gates> entryGates = new HashSet<>();
    private Set<Gates> exitGates = new HashSet<>();

    public ParkingLot(int rows, int cols, Set<Gates> entry, Set<Gates> exit) {
        for(int row = 0; row<rows; row++) {
            for(int col = 0; col<cols; col++) {
                ParkingSpace space = ParkingSpace.builder()
                        .row(row)
                        .col(col)
                        .status(ParkingStatus.AVAILABLE)
                        .active(Boolean.TRUE)
                        .build();
                available.add(space);
                entryGates = entry;
                exitGates = exit;
                entryGates.forEach(gate -> gate.setParkingLot(this));
                exit.forEach(gate -> gate.setParkingLot(this));
            }
        }

    }
    public List<ParkingSpace> getSpace(Gates gate, FetchParkingSpace fetchStrategy) {
        return fetchStrategy.fetchSpace(gate, available);
    }

    public boolean occupyParkingSpace(ParkingSpace parkingSpace) {
        if(available.contains(parkingSpace)) {
            occupied.add(parkingSpace);
            available.remove(parkingSpace);
            return true;
        }
        return false;
    }
    public boolean emptyParkingSpace(ParkingSpace parkingSpace) {
        if(occupied.contains(parkingSpace)) {
            occupied.remove(parkingSpace);
            available.add(parkingSpace);
            return true;
        }
        return false;
    }
}
