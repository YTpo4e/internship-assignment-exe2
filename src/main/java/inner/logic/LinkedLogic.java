package inner.logic;

import inner.entities.*;

import java.util.*;

public class LinkedLogic {
    private LinkedList<Join> list = new LinkedList<>();
    private LinkedList<Pair> firstTable;
    private LinkedList<Pair> secondTable;


    public LinkedLogic(List<Pair> firstTable, List<Pair> secondTable) {
        this.firstTable = new LinkedList<>(firstTable);
        this.secondTable = new LinkedList<>(secondTable);
        innerJoin();

    }

    void innerJoin() {
        ListIterator<Pair> firstIterator = firstTable.listIterator();
        ListIterator<Pair> secondIterator = secondTable.listIterator();
        Pair firstPair = firstIterator.next();
        Pair secondPair = secondIterator.next();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            int count = 1;
            while (secondPair.compareTo(firstPair) != 0) {
                if (firstPair.compareTo(secondPair) < 0) {
                    firstPair = firstIterator.next();
                } else if (firstPair.compareTo(secondPair) > 0) {
                    secondPair = secondIterator.next();
                }
            }
            while (firstPair.compareTo(secondPair) == 0) {
                list.add(new Join(firstPair.getKey(), firstPair.getValue(), secondPair.getValue()));
                if (secondIterator.hasNext()) {
                    secondPair = secondIterator.next();
                } else {
                    break;
                }
                count++;
            }

            for (int i = 0; i < count; i++) {
                if (secondIterator.hasPrevious())
                    secondIterator.previous();
            }
            if (firstIterator.hasNext() && secondIterator.hasNext()) {
                firstPair = firstIterator.next();
                secondPair = secondIterator.next();
            } else break;
        }

    }

    public void showTable() {

        System.out.println("ID A.VALUE B.VALUE");
        for (Join j : list) {
            System.out.println(j.getKey() + "  " + j.getFirstValue() + "\t   " + j.getSecondValue());
        }
    }
}
