package parkinglot;

public enum VehicleSize {
	small(10), large(20);
	private final int size;

	VehicleSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}
}
