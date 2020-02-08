package artconcurrent.fundamentals;

import artconcurrent.fundamentals.core_concurent.Bank;
import entity.BankCard;
import entity.Node;

/**
 *
 */
public class Test {
    public static void main(String[] args) {
        ConcurrentQueue cq = new ConcurrentQueue();
        Node<BankCard> node = null;
         //
        System.out.println(node.getNext());

        System.out.println(cq.succ(cq.getHead()));
    }
}
