package filesystem;

public class File extends Entry {
	private String content;
	private int size;

	File (String name, Directory parent) {
		super(name, parent);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String c) {
		content = c;
	}
	@Override
	public boolean delete() {
		if (parent == null) {
			return false;
		}
		return parent.delete(this);
	}

	boolean create() {
		return false;
	}

	@Override
	public int size() {
		return size;
	}
}
