package practice.artifact.strategy;

import practice.artifact.models.ParkingSpace;
import practice.artifact.service.Gates;

import java.util.List;
import java.util.Set;

public interface FetchParkingSpace {
    public List<ParkingSpace> fetchSpace(Gates gate, Set<ParkingSpace> available);
}
