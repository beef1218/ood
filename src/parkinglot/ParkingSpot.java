package parkinglot;

class ParkingSpot {

	private Vehicle vehicle;
	private final VehicleSize size;

	ParkingSpot(VehicleSize size) {
		this.size = size;
	}
	boolean canFit(Vehicle v) {
		//return vehicle == null && size.ordinal() >= v.getSize().ordinal();
		return vehicle == null && size.getSize() >= v.getSize().getSize();
	}

	void park(Vehicle v) {
		vehicle = v;
	}

	boolean leave(Vehicle v) {
		if (vehicle.equals(v)) {
			vehicle = null;
			return true;
		}
		return false;
	}
}
