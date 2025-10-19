package practice.artifact;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import practice.artifact.models.ParkingSpace;
import practice.artifact.service.EntryGate;
import practice.artifact.service.ExitGate;
import practice.artifact.service.Gates;
import practice.artifact.service.ParkingLot;
import practice.artifact.strategy.FarFromGate;
import practice.artifact.strategy.FetchParkingSpace;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ParkingLotApplication {
	public static void main(String[] args) {
//		SpringApplication.run(ParkingLotApplication.class, args);
        int ROWS = 4;
        int COLS = 4;
        Set<Gates> entry = new HashSet<>();
        Set<Gates> exit = new HashSet<>();
        EntryGate entryGate = EntryGate.builder()
                .name("Enter")
                .row(0)
                .col(0)
                .build();
        ExitGate exitGate = ExitGate.builder()
                .name("Exit")
                .row(4)
                .col(4)
                .build();
        entry.add(entryGate);
        exit.add(exitGate);
        ParkingLot parkingLot = new ParkingLot(ROWS, COLS, entry, exit);
        FetchParkingSpace strategy = new FarFromGate();
        List<ParkingSpace> spaces = entryGate.getParkingSpace(entryGate, strategy);
        for(ParkingSpace space : spaces){
            System.out.println(space.toString());
        }
	}

}
