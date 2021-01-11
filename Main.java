//Урок 5. Введение в ООП
//
//        1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
//        2. Конструктор класса должен заполнять эти поля при создании объекта.
//        3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
//        4. Создать массив из 5 сотрудников.
//
//        Пример:
//        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//        persArray[1] = new Person(...);
//        ...
//        persArray[4] = new Person(...);
//        5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
//

import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {

        Worker[] personArray = new Worker[5];

        creatPerson(personArray);
        printAge(personArray, 40);
    }

    public static Worker[] creatPerson(Worker[] personArray){

        String [] FIO = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев", "Петров", "Соколов", "Михайлов", "Новиков", "Федоров", "Морозов", "Волков", "Алексеев", "Лебедев"};
        String [] proff = {"Аудитор", "Актуарий", "Аналитик", "Банкир", "Брокер", "Бухгалтер", "Дилер", "Продавец", "Инкассатор", "Коммерческий директор", "Кредитный консультант", "Маркетолог", "Операционист", "Экспедитор", "Финансист", "Кассир"};

        for (int i = 0; i < personArray.length; i++) {
            personArray[i] = new Worker(FIO[random.nextInt(FIO.length - 1)], proff[random.nextInt(proff.length - 1)], FIO[random.nextInt(FIO.length - 1)] + "@mailbox.com", "8923123" + String.valueOf(random.nextInt(10)) + String.valueOf(random.nextInt(10)), ZP(), AGE());
        }
        return personArray;
    }

    public static Integer ZP(){
        Integer i;

        do{
            i = random.nextInt(100001);
        }
        while ( i < 20000);

        return i;
    }

    public static Integer AGE(){
        Integer i;

        do{
            i = random.nextInt(76);
        }
        while ( i < 20);

        return i;
    }

    public static void printAge(Worker[] personArray, Integer age){
        for (int i = 0; i < personArray.length; i++){
            if (personArray[i].getAge() > age) personArray[i].printPerson();
        }

    }


}



