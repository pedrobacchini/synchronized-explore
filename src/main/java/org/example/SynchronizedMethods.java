package org.example;

public class SynchronizedMethods {

    private int sum = 0;

    public static int staticSum = 0;

    public synchronized void calculate() {
        setSum(getSum() + 1);
    }

    public static synchronized void syncStaticCalculate() {
        staticSum = staticSum + 1;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(final int sum) {
        this.sum = sum;
    }

}
