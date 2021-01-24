package ru.lesson6.brute;

import java.util.Random;

public class Cat extends Brute{

    Random random = new Random();
    final int MAXRUN = 200;

    //не голоден
    private boolean notHungry = false;

    //у каждого кота свой объем брюха
    final int PAUNCH = 15 + random.nextInt(5);

    public Cat (String name){
        super(name);
    }

    public boolean eat (int food){
        if (food >= this.PAUNCH) return true;
        return false;
    }

    public int getPAUNCH() {
        return this.PAUNCH;
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
            System.out.println(getName() + " said, in such a distance of " + len + " meters without a brake, I will not go!");
    }



}
