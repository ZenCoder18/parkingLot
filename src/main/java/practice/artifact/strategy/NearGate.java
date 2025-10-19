package practice.artifact.strategy;

import practice.artifact.enums.ParkingStatus;
import practice.artifact.models.ParkingSpace;
import practice.artifact.service.Gates;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NearGate implements FetchParkingSpace{

    @Override
    public List<ParkingSpace> fetchSpace(Gates gate, Set<ParkingSpace> available) {
        List<ParkingSpace> space = new ArrayList<>();
        int distance = Integer.MAX_VALUE;
        for(ParkingSpace space1: available) {
            int diff = gate.getDistanceFromSpace(space1);
            if(diff<distance && space1.getStatus().equals(ParkingStatus.AVAILABLE)) {
                distance = diff;
            }
        }
        for(ParkingSpace space1 : available) {
            int diff = gate.getDistanceFromSpace(space1);
            if(diff == distance) {
                space.add(space1);
            }
        }
        return space;
    }
}
