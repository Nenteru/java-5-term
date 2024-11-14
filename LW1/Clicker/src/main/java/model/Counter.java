package model;

public class Counter {
    private int k;

    public Counter() {
        k = 0;
    }

    public Counter(int value) {
        k = value;
    }

    public int getK() {
        return k;
    }

    public void Up() {
        k += 1;
    }

    public void Down() {
        k -= 1;
    }
}
