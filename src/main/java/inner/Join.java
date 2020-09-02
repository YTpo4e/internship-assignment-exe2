package main.java.inner;

import java.util.List;

public class Join implements Comparable<Join> {
    Integer key;
    String firstValue;
    String secondValue;

    Join(Integer key, String firstValue, String secondLine) {
        this.key = key;
        this.firstValue = firstValue;
        this.secondValue = secondLine;
    }

    Join(String firstValue, String secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }


    @Override
    public int compareTo(Join o) {
        return this.key - o.key;
    }
}
