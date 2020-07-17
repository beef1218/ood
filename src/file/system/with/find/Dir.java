package file.system.with.find;

import java.util.List;

public class Dir extends Node {

	private List<Node> children;

	public Dir(String name, Dir parent) {
		super(name, parent);
	}

	@Override
	public boolean isFile() {
		return false;
	}

	public List<Node> getChildren() {
		return children;
	}
}
