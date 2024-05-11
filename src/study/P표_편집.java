package study;

import java.io.IOException;
import java.util.Stack;

class Node {
    int originIndex;
    Node next;
    Node pre;
    boolean flag;

    public Node(int originIndex) {
        this.originIndex = originIndex;
        next = null;
        pre = null;
        flag = true;
    }
}

public class P표_편집 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(8, 0, new String[]{"D 5"}));
    }


    public static String solution(int n, int k, String[] cmd) {
        String answer = "";

        Node[] nodes = new Node[n];
        nodes[0] = new Node(0);
        for (int i = 1; i < n; i++) {
            nodes[i] = new Node(i);
            nodes[i - 1].next = nodes[i];
            nodes[i].pre = nodes[i - 1];
        }

        Stack<Node> deletes = new Stack<>();
        Node nowNode = nodes[k];

        for (int i = 0; i < cmd.length; i++) {
            String[] str = cmd[i].split(" ");
            if (str[0].equals("U")) {
                int cnt = Integer.parseInt(str[1]);
                for (int j = 0; j < cnt; j++) {
                    nowNode = nowNode.pre;
                }
            } else if (str[0].equals("D")) {
                int cnt = Integer.parseInt(str[1]);
                for (int j = 0; j < cnt; j++) {
                    nowNode = nowNode.next;
                }
            } else if (str[0].equals("C")) {
                deletes.add(nowNode);
                nowNode.flag = false;

                Node preNode = nowNode.pre;
                Node nextNode = nowNode.next;

                if (preNode != null) {
                    preNode.next = nextNode;
                }
                if (nextNode != null) {
                    nextNode.pre = preNode;
                }

                if (nextNode != null) {
                    nowNode = nextNode;
                } else {
                    nowNode = preNode;
                }
            } else if (str[0].equals("Z")) {
                Node deleteNode = deletes.pop();
                deleteNode.flag = true;
                Node preNode = deleteNode.pre;
                Node nextNode = deleteNode.next;

                if (preNode != null) {
                    preNode.next = deleteNode;
                }
                if (nextNode != null) {
                    nextNode.pre = deleteNode;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nodes[i].flag) sb.append("O");
            else sb.append("X");
        }
        answer = sb.toString();
        return answer;
    }
}
