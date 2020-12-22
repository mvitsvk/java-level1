public class Main {

    public static void main(String[] args) {

        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("Задание 1:");

        byte [] mass1 = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < mass1.length; i++) {
            System.out.print("ДО: " + mass1[i]);
            if (mass1[i] == 0) { mass1[i] = 1; }
                else {
                mass1[i] = 0;
                }
            System.out.println(" ПОСЛЕ: " + mass1[i]);
        }

        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("Задание 2:");

        int[] mass2 = new int[8];
        for (int i = 0; i < mass2.length; i++) {
            mass2[i] = i * 3;
            System.out.println("POS: " +i +" RESULT: "+ mass2[i]);
        }

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("Задание 3:");

        int [] mass3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < mass3.length; i++) {
            System.out.print("[" + mass3[i]);
            if (mass3[i] < 6 ){
                mass3[i] = mass3[i] * 2;
                System.out.print(" < 6, умножаем: " + mass3[i] + "] ");
            } else {
                System.out.print("] ");
            }
        }
        System.out.println("");

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("Задание 4:");

        int size = 11; //изменяемая переменная размерности двумерного масива
        System.out.println("Кол-во элементов: " + size);
        int[][] mass4 = new int [size][size];
        for (int x = 0; x < size; x++) {
            mass4[x][x] = 1;
            mass4[x][size-x-1] = 1;
            for (int y = 0; y < size; y++) {
                System.out.print(mass4[x][y]);
            }
            System.out.println("");
        }

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("Задание 5:");

        int [] mass5 = { 1, 5, 14, 2, 15, 4, 5, -2, 4, 8, 9, -11};
        int min = 0;
        int max = 0;
        for (int i = 0; i < mass5.length; i++) {
            if ( min > mass5[i] ) {
                min = mass5[i];
            }
            if ( max < mass5[i] ) {
                max = mass5[i];
            }
            System.out.print(mass5[i] + " ");
        }
        System.out.println("");
        System.out.println("MIN=" + min + " MAX=" + max);

        //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        // если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.
        //
        //Сначала не понял постановки задачи и обратился к наставнику, ответ ниже
        //
        //привет) в этой задаче фактически необходимо определить индекс элемента массива,
        // начиная с которого сумма всех элементов справа от это индекса == сумме элементов слева от этого индекса, включая сам элемент.
        //Специально никаких символов передавать не надо
        System.out.println("Задание 6:");

        int [] mass6 = { 1, 5, 14, 2, 15, 4, 5, 2, 4, 8, 9, 11};
        System.out.println("сумма левой и правой части массива " + checkBalance (mass6));

        //записать новые данные долго. поэтому проще создать новый массив.
        int [] mass61 = { 1, 5, 14, 2, 4, 5, 2, 4, 15};
        System.out.println("сумма левой и правой части массива " + checkBalance (mass61));


        //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
        // или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
        // Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        // При каком n в какую сторону сдвиг можете выбирать сами.
        System.out.println("Задание 7: ВПЕРЕД");
        int [] mass7 = { 1, 5, 8, 2, 4, 5, 2, 4, 9};
        massMove (mass7, 5);

        System.out.println("Задание 7: НАЗАД");
        int [] mass71 = { 1, 5, 8, 2, 4, 5, 2, 4, 9};
        massMove (mass71, -6);

    }

    //функция по заданию 6.
    static boolean checkBalance (int [] mass){
        int sum_L = 0;
        int sum_R = 0;
        for (int i = 0; i < mass.length; i++) {
            sum_R = sum_R + mass[i];
        }

        int i = 0;
        while (sum_L != sum_R && i < mass.length) {
            sum_L = sum_L + mass[i];
            sum_R = sum_R- mass[i];
            i++;
            //System.out.println("TEST index=" + i + " SUM_L=" + sum_L + " SUM_R=" + sum_R);
        }
        System.out.println("index=" + i + " SUM_L=" + sum_L + " SUM_R=" + sum_R);
        return sum_L == sum_R;
    }

    //функция по заданию 7.
    static void massMove (int[] mass, int nStep){
        System.out.println("Исходные данные:");
        for (int ii = 0; ii < mass.length; ii++){
            System.out.print(" " + mass[ii]);
        }
        System.out.println("");
        System.out.println("Смещение на: " + nStep);

        int StepBuff;
        int i = 0;
        //крутим кол-во смещений
        while (nStep != i){
            //а вот тут уже смещаем массив
            if (nStep > 0) {
                StepBuff = mass[mass.length-1];
                for (int ii = mass.length-1; ii > 0 ; ii--){
                    mass[ii] = mass[ii-1];
                }
                mass[0] = StepBuff;
                i++;}
            if (nStep < 0) {
                StepBuff = mass[0];
                for (int ii = 0; ii < mass.length-1; ii++){
                    mass[ii] = mass[ii+1];
                }
                mass[mass.length-1] = StepBuff;
                i--;}
            //цикл проверки проходов смещения
//            for (int ii = 0; ii < mass.length; ii++){
//            System.out.print(" " + mass[ii]);
//            }
//            System.out.println("");
        }
        System.out.println("Результат:");
        for (int ii = 0; ii < mass.length; ii++){
            System.out.print(" " + mass[ii]);
            }
        System.out.println("");
    }
}
