package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

	public static void main(String[] args) {
		ParkingLot lot = new ParkingLot(1, 10);
		List<Vehicle> vehicles = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			final Vehicle v = i % 2 == 0 ? new Seden() : new SUV();
			vehicles.add(v);
		}

		for (Vehicle v : vehicles) {
			if (lot.canPark(v)) {
				lot.park(v);
				System.out.println("parked");
			} else {
				System.out.println("cannot park");
			}
		}
	}

	private final Level[] levels;
	public static final int DEFAULT_NUMBER_OF_LEVELS = 5;
	public static final int DEFAULT_NUMBER_OF_SPOTS_PER_LEVEL = 100;

	public ParkingLot() {
		this(DEFAULT_NUMBER_OF_LEVELS, DEFAULT_NUMBER_OF_SPOTS_PER_LEVEL);
	}

	public ParkingLot(int numOfLevels, int numOfSpotPerLevel) {
		levels = new Level[numOfLevels];
		for (int i = 0; i < levels.length; i++) {
			levels[i] = new Level(numOfSpotPerLevel);
		}
	}
	public boolean canPark(Vehicle v) {
		for (Level level : levels) {
			if (level.canFit(v)) {
				return true;
			}
		}
		return false;
	}

	public boolean park(Vehicle v) {
		for (Level level : levels) {
			if (level.canFit(v)) {
				level.park(v);
				return true;
			}
		}
		return false;
	}

	public void leave(Vehicle v) {
		for (Level level : levels) {
			if (level.leave(v)) {
				return;
			}
		}
	}
}
