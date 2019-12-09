package com.chang.algorithm.hanshunping_data_structure.hashtable;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        Emp emp = new Emp(1,"常");
        Emp emp1 = new Emp(2,"常");
        Emp emp2 = new Emp(6,"常");
        hashTable.add(emp);
        hashTable.add(emp2);
        hashTable.add(emp1);
        hashTable.list();
        hashTable.findEmpById(1);
        hashTable.findEmpById(2);
    }
}

class HashTable{
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTable(int size){
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i=0;i<size;i++){
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        int empLinkedNO = hashFun(emp.id);
        empLinkedLists[empLinkedNO].add(emp);
    }

    public void list(){
        for (int i=0;i<empLinkedLists.length;i++){
            empLinkedLists[i].list(i);
        }
    }

    public void findEmpById(int id){
        int empLinkedNO = hashFun(id);
        Emp emp = empLinkedLists[empLinkedNO].findEmpById(id);
        if (emp!=null){
            System.out.println(empLinkedNO+",id="+id+",name="+emp.name);
        }else {
            System.out.println("没找到");
        }
    }

    public int hashFun(int id){
        return id%size;
    }

}

class EmpLinkedList{
    private Emp head;

    public void add(Emp emp){
        if (head==null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(int no){
        if (head==null){
            System.out.println("第"+(no+1)+"链表信息为空");
            return;
        }
        System.out.print("第"+(no+1)+"链表信息为");
        Emp curEmp = head;
        while (true){
            System.out.printf("id=%d,name=%s\t",curEmp.id,curEmp.name);
            if (curEmp.next==null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id){
        if (head ==null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id==id){
                break;
            }
            if (curEmp.next==null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}

class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id,String name){
        super();
        this.id = id;
        this.name = name;
    }
}
