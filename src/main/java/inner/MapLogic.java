package main.java.inner;

import javafx.util.Pair;

import java.util.*;

public class MapLogic {
    private Map<Integer, List<Join>> map = new TreeMap<>();
    private Map<Integer, List<String>> firstTable;
    private Map<Integer, List<String>> secondTable;

    MapLogic(List<Pair<Integer, String>> firstTable, List<Pair<Integer, String>> secondTable) {
        this.firstTable = initMap(firstTable);
        this.secondTable = initMap(secondTable);
        searchForDuplicateKeys();

    }

    void searchForDuplicateKeys() {
        for (Map.Entry<Integer, List<String>> listEntry : firstTable.entrySet()) {
            for (Map.Entry<Integer, List<String>> listEntry1 : secondTable.entrySet()) {
                if (Objects.equals(listEntry.getKey(), listEntry1.getKey())) {
                    putJoinInTheMap(listEntry.getKey(), listEntry.getValue(), listEntry1.getValue());
                }
            }

        }
    }


    void putJoinInTheMap(Integer key, List<String> list, List<String> list1) {
        for (String string : list) {
            for (String string1 : list1) {
                List<Join> joins = map.getOrDefault(key, new ArrayList<>());
                joins.add(new Join(string, string1));
                map.put(key, joins);
            }
        }
    }


    Map<Integer, List<String>> initMap(List<Pair<Integer, String>> firstTable) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (Pair<Integer, String> first : firstTable) {
            List<String> list = map.getOrDefault(first.getKey(), new LinkedList<>());
            list.add(first.getValue());
            map.put(first.getKey(), list);
        }
        return map;
    }

    void showTable() {
        System.out.println("ID A.VALUE B.VALUE");
        for (Map.Entry<Integer, List<Join>> m : map.entrySet()) {
            for (Join j : m.getValue()) {
                System.out.println(m.getKey() + "  " + j.firstValue + "\t   " + j.secondValue);
            }
        }
    }


}
