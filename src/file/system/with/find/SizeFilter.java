package file.system.with.find;

public class SizeFilter implements Filter {
	private int sizeLimit;

	public SizeFilter(int sizeLimit) {
		this.sizeLimit = sizeLimit;
	}

	@Override
	public boolean isValid(File file) {
		return file.getSize() >= sizeLimit;
	}
}
