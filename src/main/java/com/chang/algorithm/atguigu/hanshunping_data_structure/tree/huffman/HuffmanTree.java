package com.chang.algorithm.atguigu.hanshunping_data_structure.tree.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node root = createHuffmanTree(arr);

        //测试一把
        preOrder(root); //
    }

    public static Node createHuffmanTree(int[] arr){
        List<Node> nodes = new ArrayList<>();
        for (int value:arr){
            nodes.add(new Node(value));
        }

        while (nodes.size()>1){
            Collections.sort(nodes);
            System.out.println("nodes="+nodes);
            Node leftNode = nodes.get(0);
            Node rigthNode = nodes.get(1);
            Node parent = new Node(leftNode.value+rigthNode.value);
            parent.left=leftNode;
            parent.right=rigthNode;
            nodes.remove(leftNode);
            nodes.remove(rigthNode);
            nodes.add(parent);
        }
        return nodes.get(0);

    }

    //前序遍历
    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("空树");
        }
    }
}

// 创建结点类
// 为了让Node 对象持续排序Collections集合排序
// 让Node 实现Comparable接口
class Node implements Comparable<Node> {
    int value; // 结点权值
    char c; //字符
    Node left; // 指向左子结点
    Node right; // 指向右子结点

    //写一个前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        // 表示从小到大排序
        return this.value - o.value;
    }

}
