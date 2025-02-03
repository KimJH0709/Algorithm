import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Character, Node> tree = new HashMap<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.put(root, new Node(left, right));
        }

        preorder('A', sb);
        sb.append("\n");
        inorder('A', sb);
        sb.append("\n");
        postorder('A', sb);
        System.out.println(sb.toString());

    }

    static class Node {
        char left, right;

        Node (char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    static void preorder(char cur, StringBuilder sb) {
        if (cur == '.') return;
        sb.append(cur);
        preorder(tree.get(cur).left, sb);
        preorder(tree.get(cur).right, sb);
    }

    static void inorder(char cur, StringBuilder sb) {
        if (cur == '.') return;
        inorder(tree.get(cur).left, sb);
        sb.append(cur);
        inorder(tree.get(cur).right, sb);
    }

    static void postorder(char cur, StringBuilder sb) {
        if (cur == '.') return;
        postorder(tree.get(cur).left, sb);
        postorder(tree.get(cur).right, sb);
        sb.append(cur);
    }
}