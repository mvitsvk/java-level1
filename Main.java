//1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
//2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
//3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
//4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.

//Отличное разминание мозга, при решении данной задачи.
//Да, я знаю что код можно улучшить
//возможно даже сделать проще или сложнее.

import java.util.Scanner;
import java.util.Random;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        do {
            TicTacToe(5);
            System.out.println("Еще разок? 1-Да / или любой символ");
        } while (StrEquals(scanner.nextLine(),"1"));
    }

    //Основное тело игры.
    static void TicTacToe(int size){
        char [][] field;
        //заполнить поле
        field = BoxStart(size);
        //нарисовать поле
        BoxPrint(field);
        do {
            StepGame(field,size);
            BoxPrint(field);
        } while (CheckWin(field) == false);
    }

    //ход игроков
    static char[][] StepGame(char[][] field, int size){
        String answer = "";
        int x,y;
        boolean status = false;

        do {
            System.out.println("Ваш ход, введите 2 координаты XY: ");
            answer = scanner.nextLine();

            //проверка на кол-во вводимых знаков
            if (answer.length() >= 2 ) {
                x = StrToInt(answer.charAt(0));
                y = StrToInt(answer.charAt(1));
            } else {
                x= -1;
                y= -1;
            }

            //ПРОВЕРКА НА КОРРЕКТНЫЙ ВВОД символов
            if ( x < 1 || x > size || y < 1 || y > size) {
                System.out.println("Координаты выходят за возможный диаппазон!");

            //Проверка на свободную ячейку
            } else if (CheckBox(field, x, y) == false) {
                System.out.println("Ячейка занята!");
            } else status = true;

        } while (status == false);
        field[x-1][y-1] = 'X';

        //Ход противника
        if (CheckBox(field)) StepPC(field,x,y);

        return field;
    }

    static char[][] StepPC (char[][] field, int x, int y){
        int xX, yX, z1X, z2X;
        xX = yX = z1X = z2X = 0;
        for (int i=0; i<field.length; i++){
            if (field[i][i] == 'X') z1X = z1X + 1;
            if (field[i][field.length-i-1] == 'X') z2X = z2X + 1;

            for (int j=0; j<field.length;j++){
                if (field[i][j] == 'X') xX = xX + 1;
                if (field[j][i] == 'X') yX = yX + 1;
            }
            //вот тут паника
            if (xX == field.length-1 || yX == field.length-1 || z1X == field.length-1 || z2X == field.length-1)
                return Alarm(field, x, y, xX, yX, z1X, z2X);

            // Обнуление горизонтали и вертикали
            xX = yX = 0;
        }
        // если до паники не дошло, тыкаем пальцем в небо
        return RandomStep(field);
    }

    //палец в небо
    static char[][] RandomStep(char[][]field){
        int randomX, randomY;
        do {
            randomX = random.nextInt(field.length+1);
            randomY = random.nextInt(field.length+1);
            if (randomX == 0) randomX = 1;
            if (randomY == 0) randomY = 1;
        } while (CheckBox(field, randomX, randomY) == false);
        field[randomX-1][randomY-1] = 'O';

        return field;
    }

    //Alarm
    static char[][] Alarm(char[][]field,int x, int y, int xX, int yX, int z1X, int z2X){
        //основная диагональ
        //сверху - вниз
        if (z1X == field.length-1 && CheckBox(field, x+1, y+1) == true) {
            field[x][y] = 'O';
            return field;
        }
            //снизу - вверх
            else if (z1X == field.length-1 &&  CheckBox(field, x-1, y-1) == true) {
                field[x-2][y-2] = 'O';
                return field;
            }
        //Обратная диагональ
        //сверху - вниз
        if (z2X == field.length-1 && CheckBox(field, x+1, y-1) == true) {
            field[x][y-2] = 'O';
            return field;
        }
            //снизу - вверх
            else if (z2X == field.length-1 &&  CheckBox(field, x-1, y+1) == true) {
                field[x-2][y] = 'O';
                return field;
            }
        //ПО X вперед
        if (xX == field.length-1 && yX < field.length-1 && CheckBox(field, x, y+1) == true) {
            field[x-1][y] = 'O';
            return field;
        }
            //ПО X назад
            else if (xX == field.length-1 && yX < field.length-1 && CheckBox(field, x, y-1) == true){
                field[x-1][y-2] = 'O';
                return field;
            }

        //ПО Y вперед
        if (yX == field.length-1 && xX < field.length-1 && CheckBox(field, x+1, y) == true) {
            field[x][y-1] = 'O';
            return field;
        }
            //ПО Y назад
            else if (yX == field.length-1 && xX < field.length-1 && CheckBox(field, x-1, y) == true){
                field[x-2][y-1] = 'O';
                return field;
            }
        //
        return RandomStep(field);
    }

    //Проверка выиграша
    static boolean CheckWin(char[][]field){
        int xX, xO, yX, yO, z1X, z1O, z2X, z2O;
        xX = xO = yX = yO = z1X = z1O = z2X = z2O = 0;
        for (int i=0; i<field.length; i++){
            if (field[i][i] == 'X') z1X = z1X + 1;
            if (field[i][i] == 'O') z1O = z1O + 1;

            if (field[i][field.length-i-1] == 'X') z2X = z2X + 1;
            if (field[i][field.length-i-1] == 'O') z2O = z2O + 1;
                for (int j=0; j<field.length;j++){
                    if (field[i][j] == 'X') xX = xX + 1;
                    if (field[i][j] == 'O') xO = xO + 1;

                    if (field[j][i] == 'X') yX = yX + 1;
                    if (field[j][i] == 'O') yO = yO + 1;
                }
            //Вывод поздравления X
            if (xX == field.length || yX == field.length || z1X == field.length || z2X == field.length) {
                System.out.println("Поздравляю, Вы выиграли!");
                return true;
            }
            //Вывод поздравления O
            if (xO == field.length || yO == field.length || z1O == field.length || z2O == field.length) {
                System.out.println("Увы, Выиграл Ваш противник.");
                return true;
            }
            // Обнуление горизонтали и вертикали
            xX = xO = yX = yO = 0;
        }
    if (CheckBox(field) == false) {
        System.out.println("Победила Дружба.");
        return true;
    }
    return false;
    }

    //Проверка на свободную ячейку
    static boolean CheckBox(char[][]field, int x, int y){
        if (x-1 < 0 || x > field.length || y-1 < 0 || y > field.length) return false;

        if (field[x-1][y-1] == '-') {
            field[x-1][y-1] = '-';
            return true;}
        return false;
    }

    //Проверка на свободную ячейку В принципе
    static boolean CheckBox(char[][]field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++)
                if (field[i][j] == '-') return true;
        }
        return false;
    }

    //Первоначальние заполнение
    static char[][] BoxStart(int size){
        char [][] field = new char [size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) field[i][j] = '-';
        }
        return field;
    }

    //Рисуем результат
    static void BoxPrint(char[][] field){
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field.length; j++) System.out.print(field[i][j]+" ");
            System.out.println();
        }
    }

    //Конвертация строки в число
    // 48=0 57=9
    static int StrToInt(char c){
        int s = 0;
        if ((int)c > 47 && (int)c < 58) s = ((int)c-48);
        else return -1;
        return s;
    }

    //Сравнение строк
    static boolean StrEquals (String leftStr, String rightStr){
        //Проверям длину строки
        //если длина разная то строки нет смысла проверять на содержимое
        if (leftStr.length() == rightStr.length()){
            for (int i=0; i<leftStr.length(); i++){
                if (leftStr.charAt(i) != rightStr.charAt(i)){
                    return false;
                }
            }
            return true;
        }else return false;
    }
}
