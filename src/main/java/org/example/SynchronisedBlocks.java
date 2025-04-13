package org.example;

public class SynchronisedBlocks {

    private int count = 0;
    private static int countStatic = 0;


    public void performSynchronisedTask() {
        synchronized (this) {
            setCount(getCount() + 1);
        }
    }

    public static void performStaticSyncTask() {
        synchronized (SynchronisedBlocks.class) {
            setCountStatic(getCountStatic() + 1);
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public static int getCountStatic() {
        return countStatic;
    }

    public static void setCountStatic(final int countStatic) {
        SynchronisedBlocks.countStatic = countStatic;
    }

}
