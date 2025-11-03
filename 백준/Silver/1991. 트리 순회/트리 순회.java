
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static Node[] tree;

    static class Node{
        char value;
        Node left, right;

        Node(char value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static void preOrder(Node node){
        if (node == null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void postOrder(Node node){
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

    static void inOrder(Node node){
        if ( node == null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new Node[N+1];
        for (int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            int parentIdx = parent - 'A';
            if (tree[parentIdx] == null) {
                tree[parentIdx] = new Node(parent);
            }
            if ( left != '.') {
                int leftIdx = left - 'A';
                tree[parentIdx].left = new Node(left);
                tree[leftIdx] = tree[parentIdx].left;
            }
            if ( right != '.') {
                int rightIdx = right - 'A';
                tree[parentIdx].right = new Node(right);
                tree[rightIdx] = tree[parentIdx].right;
            }
        
        }
        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);

    }
    
}
