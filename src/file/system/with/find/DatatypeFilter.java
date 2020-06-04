package file.system.with.find;

public class DatatypeFilter implements Filter {
	private String datatype;

	public DatatypeFilter(String datatype) {
		this.datatype = datatype;
	}

	@Override
	public boolean isValid(File file) {
		return file.getDatatype().equals(datatype);
	}
}
