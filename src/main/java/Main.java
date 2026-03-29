import domain.NumberGenerator;
import domain.RandomNumberGenerator;
import view.VehicleRaceInput;
import domain.VehicleRace;
import domain.Race;
import view.VehicleRaceOutput;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Race race = new VehicleRace(generator);
        VehicleRaceInput vehicleRaceInput = new VehicleRaceInput();
        VehicleRaceOutput vehicleRaceOutput = new VehicleRaceOutput();

        List<String> participantNames = vehicleRaceInput.getNamesInput();
        int numberOfRounds = vehicleRaceInput.getNumberInput();

        race.joinWithNames(participantNames);
        vehicleRaceOutput.showRace(race, numberOfRounds);
        vehicleRaceOutput.showWinnerNames(race);
    }
}
