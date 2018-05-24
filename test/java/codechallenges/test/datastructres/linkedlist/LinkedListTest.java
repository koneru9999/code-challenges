package codechallenges.test.datastructres.linkedlist;

import codechallenges.datastructures.linkedlist.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
//        addTest();

//        addAtOnEmptyTest();

//        addAtOutofBoundTest();

//        addAtTest();

//        deleteLastTest();

        deleteFirstTest();
    }

    public static void addTest() {
        LinkedList<String> list = getNewInstance();
        list.addNode("abc");
        list.addNode("def");
        list.addNode("ghi");

        list.print();

    }

    public static void addAtOnEmptyTest() {
        LinkedList<String> list = getNewInstance();
        list.insertAt(0, "xyz");
        list.print();
    }

    public static void addAtOutofBoundTest() {
        LinkedList<String> list = getNewInstance();

        list.insertAt(1, "xyz");
        list.print();
    }

    public static void addAtTest() {
        LinkedList<String> list = getNewInstance();
        list.addNode("abc");
        list.addNode("def");
        list.addNode("ghi");
        list.insertAt(1, "xyz");
        list.print();
    }

    public static void deleteLastTest() {
        LinkedList<String> list = getNewInstance();
        list.addNode("abc");
        list.addNode("def");
        list.addNode("ghi");
        list.insertAt(1, "xyz");
        list.print();

        list.deleteLast();

        list.print();
    }

    public static void deleteFirstTest() {
        LinkedList<String> list = getNewInstance();
        list.addNode("abc");
        list.addNode("def");
        list.addNode("ghi");
        list.print();

        list.deleteFirst();

        list.print();
    }

    public static <T> LinkedList<T> getNewInstance() {
        return new LinkedList<>();
    }
}
