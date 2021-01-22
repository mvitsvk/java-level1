package ru.lesson6.brute;

public class Dog extends Brute{

    final int MAXRUN = 500;
    final int MAXSWIM = 10;

    public Dog (String name){
        super(name);
    }

    @Override
    public void run(int len){
        if (len <= MAXRUN) {
            System.out.println(getName() + " RUN IS " + len + " m.");
        }
        else {
            System.out.println(getName() + " refused to run, and went to bed.");
        }
    }

    @Override
    public void swim(int len){
        if (len <= MAXSWIM) {
            System.out.println(getName() + " SWIM IS " + len + " m.");
        }
        else {
            System.out.println(getName() + " refused to swim, and went to bed.");
        }
    }

}
