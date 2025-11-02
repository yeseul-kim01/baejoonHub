import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Node{
        int num;
        Node left,right;

        Node (int num) {
            this.num = num;
        }

        void insert(int n) {
            // 현재 값 보다 새로 들어온 값이 적으면 왼쪽에다가
            if ( this.num > n) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            }
            else if (this.num == n) {
                    // 같은 키를 가지는 노드는 없다고 명시되어 있음.
                    return;
            }
            else {
                if (this.right == null) {
                    this.right = new Node(n);
                } 
                else {
                    this.right.insert(n);
                }
            }
        }
    }

    //후위식
    // 왼 - 오 - 루트
    static void postOrder(Node node){
    if (node == null) {
        return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.num);

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String s;
        while(true) {
                    s = br.readLine();
                    if(s==null || s.equals("")) {
                        break;
                    }
                    root.insert(Integer.parseInt(s));
        }
    postOrder(root); 
    
    }
}
