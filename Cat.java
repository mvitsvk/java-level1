package ru.lesson6.brute;

public class Cat extends Brute{

    final int MAXRUN = 200;

    private static int catCount;

    public Cat (String name){
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
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
