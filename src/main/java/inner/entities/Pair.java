package inner.entities;

public class Pair implements Comparable<Pair> {
    private Integer key;
    private String value;

    public Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(Pair o) {
        return this.key - o.key;
    }
}
