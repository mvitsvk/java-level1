//Урок 6. Продвинутое ООП
//        1. Создать классы Собака и Кот с наследованием от класса Животное.
//        2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//        3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//        4. * Добавить подсчет созданных котов, собак и животных.

//Урок 7. Практика ООП и работа со строками
//        1. Расширить задачу про котов и тарелки с едой. (см. в методичке)
//        2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
//        3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
//        4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
//        5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
//        6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.


import java.util.Random;
import ru.lesson6.brute.*;

public class Main {

    public static Random random = new Random();
    private static String [] NAME = {"Заика", "Черныш", "Умник", "Любим", "Миляй", "Молчан", "Буян", "Заика2", "Черныш2", "Умник2", "Любим2", "Миляй2", "Молчан2", "Буян2"};

    public static void main(String[] args) {
//        runsL6(NAME);
        runsL7(NAME);
    }

    //Сделал некоторые правки
    //ушёл от статических переменных
    //

    public static void runsL6(String [] NAME){

        Brute [] arrayBrute = new Brute[10];

        //Включаем счётчики
        // Создание 2-х классов чтобы они создавали объект
        //решил что это перебор

        //Counter BruteCount = new Counter();
        // BruteCount = CatCount + DogCount
        // поэтому не стал вообще создавать
        Counter CatCount = new Counter();
        Counter DogCount = new Counter();


        for (int i = 0; i < arrayBrute.length; i++) {
            int rand = random.nextInt(500);
            if ((rand%2) == 0) {
                arrayBrute[i] = new Cat("CAT " + NAME[random.nextInt(NAME.length - 1)]);
                CatCount.addCounter();
            }
            else {
                arrayBrute[i] = new Dog("DOG " + NAME[random.nextInt(NAME.length - 1)]);
                DogCount.addCounter();
            }

            System.out.println("Name " + arrayBrute[i].getName());
            arrayBrute[i].run(rand);
            arrayBrute[i].swim((int)rand/10);
        }
        System.out.println("ALL count=" + (CatCount.getCounter() + DogCount.getCounter()));
        System.out.println("CAT count=" + CatCount.getCounter());
        System.out.println("DOG count=" + DogCount.getCounter());
    }

    //разборки с котами
    public static void runsL7(String [] NAME){
        Cat [] arrayCat = new Cat[10];
        Bowl bowl = new Bowl();

        //насыпаем корм как повезёт
        bowl.fillFeed();

        for (int i = 0; i < arrayCat.length; i++) {

                arrayCat[i] = new Cat("CAT " + NAME[random.nextInt(NAME.length - 1)]);
                //пинаем кота к тарелке
                //если еды хватило уменьшаем кол-во еды в тарелке
                if (arrayCat[i].eat(bowl.getQuantity())) {
                    System.out.println("Спасибо, сказал " + arrayCat[i].getName());
                    bowl.muchEat(arrayCat[i].getPAUNCH());
                }
                    else {
                    System.out.println("Мяу-Мяу, Хозяин, жрать давай!!! сказал " + arrayCat[i].getName() +
                    " в тарелке " + bowl.getQuantity() + ", а я хочу " + arrayCat[i].getPAUNCH());
                    //насыпаем еду, но очередь этого кота уже прошла )))  пусть голодает.
                    bowl.fillFeed();
                }
            }

        }

}
