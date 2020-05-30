package parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Level {

	private List<ParkingSpot> spots;

	Level(int numberOfSpots) {
		List<ParkingSpot> list = new ArrayList<>(numberOfSpots);
		for (int i = 0; i < numberOfSpots; i++) {
			if (i < numberOfSpots / 2) {
				list.add(new ParkingSpot(VehicleSize.small));
			} else {
				list.add(new ParkingSpot(VehicleSize.large));
			}
		}
		spots = Collections.unmodifiableList(list); // spots becomes read-only
	}

	boolean canFit(Vehicle v) {
		for (ParkingSpot spot : spots) {
			if (spot.canFit(v)) {
				return true;
			}
		}
		return false;
	}

	boolean park(Vehicle v) {
		for (ParkingSpot spot : spots) {
			if (spot.canFit(v)) {
				spot.park(v);
				return true;
			}
		}
		return false;
	}

	boolean leave(Vehicle v) {
		for (ParkingSpot spot : spots) {
			if (spot.leave(v)) {
				return true;
			}
		}
		return false;
	}
}
