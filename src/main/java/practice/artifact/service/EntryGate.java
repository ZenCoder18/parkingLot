package practice.artifact.service;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import practice.artifact.models.ParkingSpace;
import practice.artifact.models.Ticket;
import practice.artifact.strategy.FetchParkingSpace;

import java.util.List;

@SuperBuilder
@Data
public class EntryGate extends Gates{
    public List<ParkingSpace> getParkingSpace(Gates gates, FetchParkingSpace fetchStrategy) {
        return super.getParkingLot().getSpace(gates, fetchStrategy);
    }
    public boolean occupyParkingSpace(ParkingSpace parkingSpace) {
        return false;
    }
    public Ticket issueTicket() {
        return null;
    }
}
