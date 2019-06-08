package algorithm;

/**
 * 关于二叉树的各种操作
 * 可以看到，数和图在通用领域都不常见，因为树和图的插入和删除操作都比较麻烦。
 */
public class BinaryTree {

}

/**
 * 二叉树最基本的节点类，作为节点对象，则有数组合链表（指针)两种结构来存储树结构，理解一下树结构的特点。
 * 关键left和right的指向。
 */
class Node {
    public Node(Person p) {
        this.p = p;
    }

    Person p;

    private Node left;
    private Node right;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}

class Person {
    public Person(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    String name;
    String id;
    int age;
}