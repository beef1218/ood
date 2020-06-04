package file.system.with.find;

public class File extends Node {

	private int size;
	private String datatype;

	@Override
	public boolean isFile() {
		return true;
	}

	public int getSize() {
		return size;
	}

	public String getDatatype() {
		return datatype;
	}
}
