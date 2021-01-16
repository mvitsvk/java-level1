package ru.lesson6.brute;

//Урок 6. Продвинутое ООП
//        1. Создать классы Собака и Кот с наследованием от класса Животное.
//        2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//        3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//        4. * Добавить подсчет созданных котов, собак и животных.

//run and swim

import java.util.Random;

public class Main {

    public static Random random = new Random();

    public static void main(String[] args) {
	// write your code here
        runs();
    }

    public static void runs(){

        Brute [] arrayBrute = new Brute[10];

        String [] NAME = {"Заика", "Черныш", "Умник", "Любим", "Миляй", "Молчан", "Буян"};


        for (int i = 0; i < arrayBrute.length; i++) {
            int rand = random.nextInt(500);
            if ((rand%2) == 0) arrayBrute[i] = new Cat("CAT " + NAME[random.nextInt(NAME.length - 1)]);
                    else arrayBrute[i] = new Dog("DOG " + NAME[random.nextInt(NAME.length - 1)]);

            System.out.println("Name " + arrayBrute[i].getName());
            arrayBrute[i].run(rand);
            arrayBrute[i].swim((int)rand/10);
        }


        System.out.println("ALL count=" + Brute.getBruteCount());
        System.out.println("CAT count=" + Cat.getCatCount());
        System.out.println("DOG count=" + Dog.getDogCount());
    }
}
