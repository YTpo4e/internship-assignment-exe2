package inner.logic;

import inner.entities.Join;
import inner.entities.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ArrayLogic {
    private ArrayList<Join> list = new ArrayList<>();

//    inner.logic.ArrayLogic(List<Pair<Integer, String>> firstTable, List<Pair<Integer, String>> secondTable) {
//        for (Pair<Integer, String> integerStringPair : firstTable) {
//            for (Pair<Integer, String> integerStringPair1 : secondTable) {
//                if (integerStringPair.getKey() == integerStringPair1.getKey()) {
//                    list.add(new inner.entities.Join(integerStringPair.getKey(), integerStringPair.getValue(), integerStringPair.getValue()));
//                }
//            }
//        }
//        Collections.sort(list);
//    }

    public ArrayLogic(List<Pair> firstTable, List<Pair> secondTable) {
        firstTable.stream()
                .forEach(integerStringPair -> secondTable.stream()
                        .forEach(integerStringPair1 -> {
                            if (integerStringPair1.getKey().equals(integerStringPair.getKey())) {
                                list.add(new Join(integerStringPair.getKey(), integerStringPair.getValue(), integerStringPair1.getValue()));
                            }
                        }));
    }

    public void showTable() {
        System.out.println("ID A.VALUE B.VALUE");
        for (Join j : list) {
            System.out.println(j.getKey() + "  " + j.getFirstValue() + "\t   " + j.getSecondValue());
        }
    }

}
