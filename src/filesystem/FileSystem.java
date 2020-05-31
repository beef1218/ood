package filesystem;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {

	private final Directory root;

	public FileSystem(Directory root) {
		this.root = root;
	}

	public void createFile(String path) {
		if (path.charAt(0) != '/' || path.charAt(path.length() - 1) == '/') {
			throw new IllegalArgumentException("Invalid path");
		}
		final String fileName = path.substring(path.lastIndexOf("/") + 1);
		final String dirPath = path.substring(0, path.lastIndexOf("/"));
		List<Entry> entries = resolve(dirPath);
		Directory parent = (Directory)entries.get(entries.size() - 1);
		parent.createFile(fileName);
	}

	/*
	return convert string path into list of directories
	 */
	private List<Entry> resolve(String path) {
		if (!path.startsWith("/")) {
			throw new IllegalArgumentException("Invalid path");
		}
		String[] components = path.substring(1).split("/");
		List<Entry> entries = new ArrayList<>(components.length + 1);
		entries.add(root);

		Directory dir = root;
		for (String component : components) {
			if (dir == null || !(dir instanceof Directory)) {
				throw new IllegalArgumentException("Invalid path");
			}
			dir = (Directory)dir.getChild(component);
			entries.add(dir);
		}
		return entries;
	}

	public void updateFile(String path, String content) {

	}
}
