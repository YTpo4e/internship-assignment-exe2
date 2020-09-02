package main.java.inner;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ArrayLogic {
    private ArrayList<Join> list = new ArrayList<>();

//    ArrayLogic(List<Pair<Integer, String>> firstTable, List<Pair<Integer, String>> secondTable) {
//        for (Pair<Integer, String> integerStringPair : firstTable) {
//            for (Pair<Integer, String> integerStringPair1 : secondTable) {
//                if (integerStringPair.getKey() == integerStringPair1.getKey()) {
//                    list.add(new Join(integerStringPair.getKey(), integerStringPair.getValue(), integerStringPair.getValue()));
//                }
//            }
//        }
//        Collections.sort(list);
//    }

    ArrayLogic(List<Pair<Integer, String>> firstTable, List<Pair<Integer, String>> secondTable) {
        firstTable.stream()
                .forEach(integerStringPair -> secondTable.stream()
                        .forEach(integerStringPair1 -> {
                            if (integerStringPair1.getKey().equals(integerStringPair.getKey())) {
                                list.add(new Join(integerStringPair.getKey(), integerStringPair.getValue(), integerStringPair1.getValue()));
                            }
                        }));

        Collections.sort(list);
    }

    void showTable() {
        System.out.println("ID A.VALUE B.VALUE");
        for (Join j : list) {
            System.out.println(j.key + "  " + j.firstValue + "\t   " + j.secondValue);
        }
    }

}
