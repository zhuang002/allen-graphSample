import java.util.ArrayList;

public interface Tree {
	Object getRoot();
	void listAllNodesDFS();
	void listAllNodesBFS();
	Object[] getAllLeaves();
	int getDepth();
	Tree changeRoot(Object newRoot);
	void loadTree();
}
