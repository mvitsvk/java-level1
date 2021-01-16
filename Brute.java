package ru.lesson6.brute;

public abstract class Brute {
    private String name;

    private static int bruteCount;

    public Brute(String name){
        this.name = name;
        bruteCount++;
    }

    public static int getBruteCount() {
        return bruteCount;
    }

    public String getName() {
        return name;
    }

    public abstract void run(int len);

    public abstract void swim (int len);

}
