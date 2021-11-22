import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Tree {
    private class Node {
        int data;
        Node left;
        Node right;
        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "node= " + data;
        }
    }

    private Node root;
    private static int max_level = 0;

    public int visibleNodes() {
        // Write your code here
        ArrayList<Integer> visibleNodes = new ArrayList<>();
        visibleNodes(root, 1, visibleNodes);
        return visibleNodes.size();
    }

    private void visibleNodes(Node node, int level, ArrayList<Integer> visibleNodes) {
        if (node == null) return;

        if (max_level < level) {
            visibleNodes.add(node.data);
            max_level = level;
        }

        visibleNodes(node.left, level + 1, visibleNodes);
        visibleNodes(node.right, level + 1 , visibleNodes);
    }

    public ArrayList<Integer> visibleNodesByLevelOrder() {
        return visibleNodesByLevelOrder(root);
    }

    private ArrayList<Integer> visibleNodesByLevelOrder(Node root) {
        // Write your code here
        ArrayList<Integer> visibleNodes = new ArrayList<>();

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 1; i <= n; i++) {
                Node node = queue.remove();

                if (i == 1)
                    visibleNodes.add(node.data);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add((node.right));
            }
        }

        return visibleNodes;
    }

    public void insert(int value) {
        var node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        var current = root;
        while (true) {
            if (value < current.data) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }
    }

}
