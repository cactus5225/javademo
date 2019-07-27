package DataStructureAndAlgorithms;

import java.io.Serializable;

/**
 * 单链表反转 2019-7-27
 */
public class SingleLinkedList<T> implements Serializable {
    public SingleLinkedList() {
    }

    public static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node first;

    /**
     * 添加在列表后面
     *
     * @param
     */
    public void add(Node<T> newNode) {
        if (first == null) {
            first = newNode;
        }else {
            first.next = newNode;
        }
    }

    //怎么做循环遍历,好像不用做循环

    public static void main(String[] args) {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<>();
        Node<String> A = new Node<>("a", null);
        singleLinkedList.add(A);
        Node<String> B = new Node<>("b", null);
        singleLinkedList.add(B);
        Node<String> C = new Node<>("c", null);
        singleLinkedList.add(C);
        System.out.println(singleLinkedList.first.next.data);
    }


}
