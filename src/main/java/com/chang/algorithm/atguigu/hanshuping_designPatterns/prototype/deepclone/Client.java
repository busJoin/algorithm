package com.chang.algorithm.atguigu.hanshuping_designPatterns.prototype.deepclone;

public class Client {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        DeepProtoType p = new DeepProtoType();
        p.name = "宋江";
        p.deepCloneableTarget = new DeepCloneableTarget("大牛", "小牛");

        //方式1 完成深拷贝
		DeepProtoType p2 = (DeepProtoType) p.clone();
		System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode()+":"+p.deepCloneableTarget);
		System.out.println("p2.name=" + p.name + "p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode()+":"+p2.deepCloneableTarget);

        //方式2 完成深拷贝
        DeepProtoType p3 = (DeepProtoType) p.deepClone();
        System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode()+":"+p.deepCloneableTarget);
        System.out.println("p3.name=" + p.name + "p3.deepCloneableTarget=" + p3.deepCloneableTarget.hashCode()+":"+p3.deepCloneableTarget);

    }
}
