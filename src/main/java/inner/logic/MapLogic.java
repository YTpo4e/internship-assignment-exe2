package inner.logic;

import inner.entities.Join;
import inner.entities.Pair;


import java.util.*;

public class MapLogic {
    private Map<Integer, List<Join>> map = new HashMap<>();
    private Map<Integer, List<String>> firstTable;
    private Map<Integer, List<String>> secondTable;

    public MapLogic(List<Pair> firstTable, List<Pair> secondTable) {
        this.firstTable = initMap(firstTable);
        this.secondTable = initMap(secondTable);
        innerJoinMap();
    }


    void innerJoinMap() {
        for (Map.Entry<Integer, List<String>> first : firstTable.entrySet()) {
            if (secondTable.containsKey(first.getKey())) {
                for (int i = 0; i < first.getValue().size(); i++) {
                    List<Join> tempList = map.getOrDefault(first.getKey(), new ArrayList<>());
                    for (int j = 0; j < secondTable.get(first.getKey()).size(); j++) {
                        tempList.add(new Join(first.getKey(), first.getValue().get(i), secondTable.get(first.getKey()).get(j)));
                        map.put(first.getKey(), tempList);
                    }
                }
            }
        }
    }

    Map<Integer, List<String>> initMap(List<Pair> firstTable) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (Pair first : firstTable) {
            List<String> list = map.getOrDefault(first.getKey(), new LinkedList<>());
            list.add((String) first.getValue());
            map.put((Integer) first.getKey(), list);
        }
        return map;
    }

    public void showTable() {
        System.out.println("ID A.VALUE B.VALUE");
        for (Map.Entry<Integer, List<Join>> m : map.entrySet()) {
            for (Join j : m.getValue()) {
                System.out.println(m.getKey() + "  " + j.getFirstValue() + "\t   " + j.getSecondValue());
            }
        }
    }
}
