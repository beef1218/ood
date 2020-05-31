package filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
	private List<Entry> contents;

	Directory(String name, Directory parent) {
		super(name, parent);
		contents = new ArrayList<>();
	}

	@Override
	public boolean delete() {
		if (parent == null || contents.size() > 0) {
			return false;
		}
		return parent.delete(this);
	}

	boolean delete(Entry entry) {
		return contents.remove(entry);
	}

	public List<Entry> getContents() {
		return contents;
	}

	protected Entry getChild(String name) {
		for (Entry e : contents) {
			if (e.name.equals(name)) {
				return e;
			}
		}
		return null;
	}
	void createFile(String fileName) {
		for (Entry e : contents) {
			if (e.name.equals(fileName) && e instanceof File) {
				throw new IllegalArgumentException("File already exists");
			}
		}
		Entry newFile = new File(fileName, this);
		contents.add(newFile);
	}

	@Override
	public int size() {
		int size = 0;
		for (Entry entry : contents) {
			size += entry.size();
		}
		return size;
	}

	public int numberOfFiles() {
		int count = 0;
		for (Entry e : contents) {
			if (e instanceof Directory) {
				Directory d = (Directory)e;
				count += d.numberOfFiles();
			}
			count++;
		}
		return count;
	}

}
