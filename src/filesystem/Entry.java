package filesystem;

public abstract class Entry {
	protected String name;
	protected long updated;
	protected long created;
	protected Directory parent;

	Entry(String name, Directory parent) {
		this.name = name;
		this.parent = parent;
		created = System.currentTimeMillis();
		updated = created;
	}

	public String getName() {
		return name;
	}

	public abstract int size();

	public abstract boolean delete();

	public String getFullPath() {
		if (parent == null) {
			return name;
		}
		return parent.getFullPath() + "/" + name;
	}

	public long getCreated() {
		return created;
	}

	public void rename(String name) {
		this.name = name;
	}
}
