
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    //выбор игры
        select();
    }

    static void select(){
        //дефолтное значение которое перезапишется новым запросом
        String scan = "";
        while (scan.equals("0") == false) {
            System.out.println("Выберите игру");
            System.out.println("1. Угадай число");
            System.out.println("2. Угадай слово");
            System.out.println("0. Выход");
            scan = scanner.nextLine();
            if (scan.equals("1")){
                //GuessNumber();
                GuessNumber2();
            }
            else if (scan.equals("2")){
                GuessString();
            }
            else if (scan.equals("0")){
                System.out.println("Всего доброго.");
            }
            else {
                System.out.println("Вы, что-то не то выбираете!");
            }
        }
    }
    //1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
    // При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
    // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

//    Сначала сделал так.
//    во первых всё в одной процедуре
//    во вторых используя то что еще не изучали
//    Удалять не стал, оставил на обозрение.

    static void GuessNumber(){
        do {
            int count = 0;
            String guess = "";
            int number = random.nextInt(10);
            //для тестирования
            //System.out.println("Загадано " + number);
            // 3 попытки и не угадал
            //преобразование в строку для возможности отлова любых символов
            while (count < 3 && guess.equals(Integer.toString(number)) == false) {
                System.out.print("Угадай число от (0..9): ");
                guess = scanner.nextLine();
                if (guess.equals(Integer.toString(number)) == false) {
                    // пришлось гуглить, но отлов исключения необходим!
                    try {
                        System.out.println("Увы, надо " + ((Integer.parseInt(guess) > number) ? "меньше" : "больше"));
                    } catch (NumberFormatException e) {
                        System.err.println("Неправильный формат строки!");
                    }
                    count++;
                    System.out.println("Попыток осталось " + (3 - count));
                }
            }
            try {
            System.out.println("Вы " +
                    ((Integer.parseInt(guess) == number) ? "Победили! " : "Проиграли.%sВы загадывали " + number));
            } catch (NumberFormatException e) {
                System.err.println("И это... Вы проиграли!");
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        } while (scanner.nextLine().equals("1") == true);
    }

    //потом решил усложнить себе жизнь
    static void GuessNumber2(){
        do {
            int count = 0;
            //при первой проверке строки пусты и равны
            //в итоге ловим баг. поэтому изначально пробел
            String guess = " ";
            double number = random.nextInt(10);
            //для тестирования
            //System.out.println("Загадано " + number);
            // 3 попытки и не угадал
            //преобразование в строку для исключения использования TRY
            while (count < 3 && StrEquals(guess,IntToStr(number)) == false) {
                System.out.print("Угадай число от (0..9): ");
                guess = scanner.nextLine();
                if(StrToInt(guess) >=0){
                    if (StrEquals(guess,IntToStr(number)) == false) {
                        System.out.println("Увы, надо " + ((StrToInt(guess) > number) ? "меньше" : "больше"));
                        count++;
                        System.out.println("Попыток осталось " + (3 - count));
                    }
                } else {
                        System.out.println("Тремар конечностей засчитан.");
                        count++;
                        System.out.println("Попыток осталось " + (3 - count));
                }
            }
            System.out.println("Вы " + ((StrToInt(guess) == number) ? "Победили! " : "Проиграли: " + number));
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        //да. я вкурсе, что если ввести данные отличные от 1 то будет выход
        } while (StrEquals(scanner.nextLine(),"1") == true);
    }

    //    2. * Создать массив из слов
    //
    //    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
    //            При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //            сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
    //            Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
    //    apple – загаданное
    //    apricot - ответ игрока
    //    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //    Для сравнения двух слов посимвольно можно пользоваться:
    //    String str = "apple";
    //    char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
    //    Играем до тех пор, пока игрок не отгадает слово.
    //    Используем только маленькие буквы.
    static void GuessString(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        do {
            int number = random.nextInt(words.length);
            String word = words [number];
            String wordPart = "";
            String answer = "";
            boolean status = false;
            //отладочное сообщение
            System.out.println(word);

            System.out.println("Угадай слово.");
            do {
                System.out.print("Ваш вариант: ");
                //спросить и сразу в нижний регистр
                answer = scanner.nextLine().toLowerCase();

                //делаем проверку и сохраняем результат
                //чтобы дважды не обращатся к процедуре
                status = StrEquals(word,answer);

                if (status == false){
                    wordPart = WordPart(word,wordPart);
                } else System.out.println("Поздравляю! Вы угадали слово.");

                // а вот тут придётся делать повтор
                //т.к. сравнение других переменных
                if (StrEquals(word,wordPart) == true) {
                    status = true;
                    System.out.println("Увы, Вы не угадали слово.");
                }

            } while ( status == false);
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        //да. я вкурсе, что если ввести данные отличные от 1 то будет выход
        } while (StrEquals(scanner.nextLine(),"1") == true);

    }

    // помогашки для основных задач

    //вычисление части слова
    static String WordPart(String word, String wordPart){
        String str = "";
        for (int i = 0; i < wordPart.length()+1; i++)
            str = str + word.charAt(i);
        WordViewer(str);
        return str;
    }

    //Вывод части слова + * доведение до 15-ти
    static void WordViewer(String str){
        System.out.print("Слово: " + str);
        for (int i = str.length(); i < 15; i++)
            System.out.print("*");
        System.out.println();
    }

    //Сравнение строк
    static boolean StrEquals (String leftStr, String rightStr){
        //Проверям длину строки
        //если длина разная то строки нет смысла проверять на содержимое
        if (leftStr.length() == rightStr.length()){
            for (int i=0; i<leftStr.length(); i++){
                if (leftStr.charAt(i) != rightStr.charAt(i)){
                    //System.out.println("Символ " + leftStr.charAt(i) + " Не равен " + rightStr.charAt(i));
                    return false;
                }
                //else System.out.println("Символ " + leftStr.charAt(i) + " равен " + rightStr.charAt(i));
            }
            return true;
        }else return false;
    }

    //Конвертация строки в число
    // 48=0 57=9
    static double StrToInt(String string){
        double s = 0;
        char c;
        for (int i=0; i<string.length(); i++) {
            c = string.charAt(i);
            if ((int)c > 47 && (int)c < 58) {
                if (string.length() == 1) s = ((int)c-48);
                else s = s + ((int)c-48) * Math.pow(10, string.length()-i-1);
            } else return -1;
        }
        return s;
    }

    //Конвертация число в строку
    // 48=0 57=9
    static String IntToStr(double IntStr){
        String s = "";
        int A_B_division = 0;
        for (int i = (int)Math.log10(IntStr); i >= 0; i--){
            A_B_division = (int)(IntStr / Math.pow(10, i));
            IntStr = IntStr - (A_B_division * Math.pow(10, i));
            s= s + (char)( 48 + A_B_division);
        }
        return s;
    }

}
