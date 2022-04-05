package linkedlist;

import java.util.Objects;

/**
 * @description: 节点
 * @author: xuefei
 * @date: 2022/03/02 00:09
 */
public class Node {
    Node next;
    Integer data;

    public Node() {
    }

    public Node(Integer data) {
        this.data = data;
    }

    public Node(Node next, Integer data) {
        this.next = next;
        this.data = data;
    }

    public Node(Integer data, Node next) {
        this.next = next;
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(next, node.next) &&
                Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, data);
    }
}
