package entity;

import com.sun.istack.internal.NotNull;

/**
 * 链表的节点
 */
public class Node<T> {
    /*使用Object存储数据，更具有普遍性*/
    T a;
    Node next;

    public Node(@NotNull T a) {
        this.a = a;
    }

    public Node getNext(){
        return next;
    }
}
