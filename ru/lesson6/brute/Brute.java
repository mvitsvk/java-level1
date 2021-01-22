package ru.lesson6.brute;

public abstract class Brute {
    private String name;

    public Brute(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void run(int len);

    public abstract void swim (int len);

}
