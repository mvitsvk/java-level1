public class Main {

    public static void main(String[] args) {
	    // data types zad2
        byte by = -120;
        short sh = 32767;
        int i = 1000000;
        long lo = 1000000000;
        float fl = 10.75F;
        double dou = 10.76;
        boolean boo = true;
        char ch='A';
        String st = "WORLD";

        //zad3
        System.out.println(zad3(1.5F,0.75F,3.56F,4.33F));

        //zad4
        System.out.println("MIN " + zad4(9,0));
        System.out.println("OK " + zad4(9,10));
        System.out.println("MAX " + zad4(9,12));

        //zad5
        zad5 (5);
        zad5 (0);
        zad5 (-5);

        //zad6
        System.out.println(zad6(-9));
        System.out.println(zad6(9));

        //zad7
        zad7("Максим");

        //zad8
        //up
        zad8(1788);
        //down
        zad8(1829);
        //up
        zad8(2020);
        //down
        zad8(2023);
        //вот это не понял
        //кроме каждого 100-го, при этом каждый 400-й – високосный
        //
        //РЕАЛЬЗОВЫВАТЬ НЕ СТАЛ


    }
    //////////////////SUB///////////////////

    //zad3
    static float zad3(float a, float b, float c, float d) {
        //check Division by zero
        if (d != 0) {
            return a * (b + (c / d));
        }
        return 0;
    }

    //zad4
    static boolean zad4(int a1, int a2) {
        return a1 + a2 >= 10 && a1 + a2 <= 20;
    }

    //zad5
    static void zad5(int a){
        if (a >= 0) {
            System.out.println(a + " Число положительное");
        } else {
            System.out.println(a + " Число отризательное");
        }
    }

    //zad6
    static boolean zad6(int a){
        return a < 0;
    }

    //zad7
    static void zad7(String a){
        System.out.println("Привет, " + a + "!");
    }

    //zad8
    static void zad8(int year){
        if (year%4 == 0 ) {
            System.out.println("Год " + year + " высокосный, чтоб его...");
        }
        else {
            System.out.println("Год " + year + " не высокосный, повезло.");
        }
    }

}
