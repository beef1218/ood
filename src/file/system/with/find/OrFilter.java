package file.system.with.find;

public class OrFilter implements Filter {
	private Filter f1;
	private Filter f2;

	public OrFilter(Filter f1, Filter f2) {
		this.f1 = f1;
		this.f2 = f2;
	}

	@Override
	public boolean isValid(File file) {
		return f1.isValid(file) || f2.isValid(file);
	}
}
