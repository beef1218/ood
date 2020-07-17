package file.system.with.find;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
	public static void main(String[] args) {
		Node root = new Dir("ROOT", null);
		FileSystem system = new FileSystem(root);
		Filter sizeFilter = new SizeFilter(1000);
		Filter datatypeFilter = new DatatypeFilter("xml");
		Filter andFilter = new AndFilter(sizeFilter, datatypeFilter);
		List<Node> result = system.search(andFilter);
		System.out.println(result);
	}

	private Node root;
	public FileSystem(Node root) {
		this.root = root;
	}

	public List<Node> search(Filter filter) {
		List<Node> result = new ArrayList<>();
		search(root, filter, result);
		return result;
	}

	private void search(Node node, Filter filter, List<Node> result) {
		if (node.isFile() && filter.isValid((File)node)) {
			result.add(node);
			return;
		}

		if (!node.isFile()) {
			Dir dir = (Dir)node;
			for (Node child : dir.getChildren()) {
				search(child, filter, result);
			}
		}
	}
}
