package com.chang.algorithm.hanshunping_data_structure.tree;

import lombok.Data;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先需要创建一颗二叉树
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        /*root.perOrder();
        System.out.println("-------------");
        root.infixOrder();
        System.out.println("------------");
        root.postOrder();*/


        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        arrayBinaryTree.preOrder(0);



    }
}

class ArrayBinaryTree{
    private int arr[];
    public ArrayBinaryTree(int[] arr){
        this.arr = arr;
    }
    /**
     * 前序遍历
     */
    public void preOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空");
        }
        System.out.println(arr[index]);
        if (index*2+1<arr.length){
            preOrder(index*2+1);
        }
        if (index*2+2<arr.length){
            preOrder(index*2+2);
        }
    }
}

/**
 * 链表结构二叉树
 */
@Data
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no,String name){
        this.no = no;
        this.name = name;
    }

    /**
     * 前序遍历
     */
    public void perOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.perOrder();
        }
        if (this.right!=null){
            this.right.perOrder();
        }
    }

    /**
     * 中序排序
     */
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        if (this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

}
