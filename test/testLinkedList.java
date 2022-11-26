import bjava.util.List.LinkedList;

public class testLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> test = new LinkedList<>();
        test.add(0,1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.remove(0);
        LinkedList<Integer> head = test.clone();
        test.remove(0);
        head.remove(1);
        test.add(8);
        head.add(9);
        test.add(10);
        test.point = test.getTail();
        test.point.next = head.getHead();
        test.setTail(head.getTail());
        System.out.println(test);
        System.out.println(test.toString());
        System.out.println(head);
        System.out.println();
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(20);
        list1.add(21);
        list1.add(22);
        list1.add(23);
        list1.add(24);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(30);
        list2.add(31);
        list2.add(32);
        list2.add(33);
        list2.add(34);
        test.LinkList(list1);
        System.out.println(test);
        test.LinkList(list2.getHead());
        System.out.println(test);
        test.add(11);
    }
}