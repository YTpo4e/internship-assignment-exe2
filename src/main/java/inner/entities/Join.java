package inner.entities;

public class Join implements Comparable<Join> {
    private Integer key;
    private String firstValue;
    private String secondValue;

    public Join(Integer key, String firstValue, String secondLine) {
        this.key = key;
        this.firstValue = firstValue;
        this.secondValue = secondLine;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(String firstValue) {
        this.firstValue = firstValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(String secondValue) {
        this.secondValue = secondValue;
    }

    @Override
    public int compareTo(Join o) {
        return this.key - o.key;
    }
}
