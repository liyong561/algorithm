package artconcurrent.fundamentals;

import artconcurrent.fundamentals.core_concurent.Bank;
import entity.BankCard;
import entity.Node;

/* 自己尝试一些并发队列*/
public class ConcurrentQueue {
    private volatile Node<BankCard> head;
    private volatile Node<BankCard> tail;

    public ConcurrentQueue(){
        /*并发集合的构造函数。 */
        head = tail = new Node<>(null);
    }
    public final Node<BankCard> succ(Node<BankCard> p) {
        Node<BankCard> next = p.getNext();
        return p == next ? head : next;
    }
    public Node<BankCard> getHead(){
        return head;
    }
}
