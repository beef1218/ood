package file.system.with.find;

public abstract class Node {
	private long created;
	private String name;
	private Dir parent;

	public abstract boolean isFile();

	public Node(String name, Dir parent) {
		this.name = name;
		this.parent = parent;
		this.created = System.currentTimeMillis();
	}
}
