import java.util.LinkedList;
import java.util.Queue;

public class Traversal {
    public static void main(String[] args) {
        // create tree
        Node root = new Node(
            new Node(new Node("D"), new Node("E"), "B"),
            new Node(new Node("F"), new Node("G"), "C"),
            "A"
        );
        preorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        breadthFirst(root);
        System.out.println();
    }

    public static void preorder(Node root) {
        if (root != null) {
            System.out.printf("%s ", root.value);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.printf("%s ", root.value);
        }
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.printf("%s ", root.value);
            inorder(root.right);
        }
    } // D B E A F C G

    public static void breadthFirst(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.printf("%s ", cur.value);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null) 
                queue.add(cur.right);
        }
    } // A B C D E F G
}

class Node {
    Node left;
    Node right;
    String value;

    public Node(Node left, Node right, String value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
    public Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
