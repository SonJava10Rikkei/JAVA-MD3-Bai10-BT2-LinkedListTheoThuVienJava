package rikkei;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    private Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    //    thêm một phần tử vào danh sách tại vị trí chỉ định.


    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = getNode(index - 1);
            newNode.next = previous.next;
            previous.next = newNode;
        }
        numNodes++;
    }

    //    thêm một phần tử vào đầu danh sách.
    public void addFirst(E e) {
        add(0, e);
    }

    //    thêm một phần tử vào cuối danh sách.
    public void addLast(E e) {
        add(numNodes, e);
    }

    //    xóa phần tử ở vị trí chỉ định khỏi danh sách
    public E removed(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException();
        }

        Node removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else {
            Node previous = getNode(index - 1);
            removedNode = previous.next;
            previous.next = removedNode;
        }
        numNodes--;
        return removedNode.element;
    }

    //    trả về chỉ số đầu tiên của (giá trị) phần tử chỉ định trong danh sách.
    public int indexOf(E o) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.element.equals(o)) {
                return index;
            }

            current = current.next;
            index++;
        }
        return -1;
    }

    //    xóa phần tử chỉ định khỏi danh sách. Cần indexOf
    public boolean remove(Object e) {
        int index = indexOf((E) e);
        if (index == -1) {
            return false;
        } else {
            remove(index);
            return true;
        }

    }

    //    trả về số lượng phần tử trong danh sách.
    public int size() {
        return numNodes;
    }

    //    tạo ra một bản sao của danh sách
    public E clone() {
        MyLinkedList<E> newList = new MyLinkedList<E>();
        Node current = head;
        while (current != null) {
            newList.addLast(current.element);
            current = current.next;
        }

        return (E) newList;

    }

    //    kiểm tra xem phần tử chỉ định có trong danh sách hay không.
    public boolean contains(E o) {
        return indexOf(o) != -1;
    }

    //thêm một phần tử vào cuối danh sách.
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    //đảm bảo rằng danh sách có đủ dung lượng để chứa số lượng phần tử chỉ định.
    public void ensureCapacity(int minCapacity) {
        //không làm gì cả, LinkedList trong Java tự động thay đổi kích thước khi cần
    }

    //trả về phần tử ở vị trí chỉ định trong danh sách
    public E get(int i) {
        if (i < 0 || i >= numNodes) {
            throw new IndexOutOfBoundsException();
        }

        Node node = getNode(i);
        return node.element;
    }

    //trả về phần tử đầu tiên trong danh sách.
    public E getFirst() {
        if (numNodes == 0) {
            throw new NoSuchElementException();
        }

        return head.element;
    }

    //trả về phần tử cuối cùng trong danh sách.
    public E getLast() {
        if (numNodes == 0) {
            throw new NoSuchElementException();
        }
        Node lastNode = getNode(numNodes - 1);
        return lastNode.element;
    }

    //    xóa tất cả các phần tử trong danh sách.
    public void clear() {
        head = null;
        numNodes = 0;
    }

    private class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }
    }


}
