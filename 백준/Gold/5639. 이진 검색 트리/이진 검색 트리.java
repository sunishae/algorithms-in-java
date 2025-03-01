import java.io.*;
import java.util.*;

public class Main {
    static Node head = null;

    static void insertNode(Node head, int n) {
        if(head.data < n){
            if(head.right == null)
                head.right = new Node(n);
            else
                insertNode(head.right, n);
        }
        else{
            if(head.left == null)
                head.left = new Node(n);
            else
                insertNode(head.left, n);
        }
    }


    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        head = new Node(n);

        String input;
        while (true) {
            input = br.readLine();
            if(input == null || input.equals("")) break;
            insertNode(head, Integer.parseInt(input));
        }

        postOrder(head);

        bw.flush();
        bw.close();
    }

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data = d;
            left = null;
            right = null;
        }
    }

    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + "\n");
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
