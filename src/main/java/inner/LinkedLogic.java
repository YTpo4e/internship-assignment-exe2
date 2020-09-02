package main.java.inner;

import javafx.util.Pair;

import java.util.*;

public class LinkedLogic {
    private LinkedList<Join> list = new LinkedList<>();
    private LinkedList<Pair<Integer, String>> firstTable;
    private LinkedList<Pair<Integer, String>> secondTable;


    LinkedLogic(List<Pair<Integer, String>> firstTable, List<Pair<Integer, String>> secondTable) {
        this.firstTable = new LinkedList<>(firstTable);
        this.secondTable = new LinkedList<>(secondTable);
        innerJoin();

    }

    void innerJoin() {
        Iterator<Pair<Integer, String>> firstIterator = firstTable.iterator();
        while (firstIterator.hasNext()) {
            Pair<Integer, String> firstElement = firstIterator.next();
            Iterator<Pair<Integer, String>> secondIterator = secondTable.iterator();
            while (secondIterator.hasNext()) {
                Pair<Integer, String> secondElement = secondIterator.next();
                if (Objects.equals(firstElement.getKey(), secondElement.getKey())) {
                    list.add(new Join(firstElement.getKey(), firstElement.getValue(), secondElement.getValue()));
                }
            }
        }
        Collections.sort(list);
    }

    void showTable() {
        System.out.println("ID A.VALUE B.VALUE");
        for (Join j : list) {
            System.out.println(j.key + "  " + j.firstValue + "\t   " + j.secondValue);
        }
    }
}
