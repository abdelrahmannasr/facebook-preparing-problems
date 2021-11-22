import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodesSubtree {
    // Tree Node
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Query {
        int u;
        char c;
        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }

    public int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        if (root == null) return new int[] {0};

        Map<Character, Integer> map;
        int[] results = new int[queries.size()];
        int i =0;

        for(Query query: queries) {
            Node current = null;
            map = new HashMap<>();

            if (root.val != query.u){
                for (Node child : root.children)
                    if (child.val == query.u)
                        current = child;
            } else
                current = root;

            if (current != null)
                traverse(current, s, query, map);

            if (!map.isEmpty())
                results[i++] = map.get(query.c);
        }

        return results;
    }

    private void traverse(Node root, String s, Query query, Map<Character, Integer> map) {
        if (root == null) return;

        if (s.charAt(root.val - 1) == query.c) {
            map.put(query.c, map.getOrDefault(query.c, 0) + 1);
        }

        for (Node child: root.children)
            traverse(child, s, query, map);

        return;
    }
}
