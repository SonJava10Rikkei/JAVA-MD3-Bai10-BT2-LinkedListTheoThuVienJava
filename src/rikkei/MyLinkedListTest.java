package rikkei;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        myLinkedList.add(0, 50);
        myLinkedList.add(1, 61);
        myLinkedList.add(2, 72);
        myLinkedList.add(3, 83);
        myLinkedList.add(4, 94);


        System.out.println(myLinkedList.get(3));
//        System.out.println(myLinkedList.indexOf(61));
//        System.out.println(myLinkedList.addFirst(1));
//        System.out.println(myLinkedList.addLast(6));
        System.out.println(myLinkedList.removed(0));
        System.out.println(myLinkedList.remove(2));
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.clone());
        System.out.println(myLinkedList.contains(61));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.getFirst());
        System.out.println(myLinkedList.getLast());
//        System.out.println(myLinkedList.clear());

    }
}
