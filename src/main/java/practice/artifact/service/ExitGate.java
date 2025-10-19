package practice.artifact.service;

import lombok.experimental.SuperBuilder;
import practice.artifact.models.ParkingSpace;

@SuperBuilder
public class ExitGate extends Gates{
    public Integer payment() {
        return null;
    }
    public boolean unpark(ParkingSpace space) {
        return false;
    }
}
