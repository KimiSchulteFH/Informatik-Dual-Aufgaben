package dual.info.mfi2;

import java.sql.SQLOutput;

public class UE04 {

    private static float f_1(float y) {
        return (float) Math.sqrt(y);
    }
    private static float f_2(float y) {
        if(y < 0.5f) {
            return 0;
        } else if (y > 0.5f) {
            return 1;
        } else {
            return 17;
        }
    }

    public static float locate_y_value(float y, float a, float b) {
        float konstante = 0.1f;

        if(Math.abs(a - b) < konstante)
            return f_2(y);
        float halb = (a + b) / 2;
        if(y > halb) {
            return locate_y_value(y, halb, b);
        } else {
            return locate_y_value(y, a, halb);
        }
    }

    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        float y = 0.5f;
        System.out.println(locate_y_value(y, a, b));
        System.out.println(locate_y_value_iterativ(y,a,b));
    }

    public static float locate_y_value_iterativ(float y, float a, float b) {
        float konstante = 0.1f;
        while(Math.abs(a-b) > konstante) {
            if(y < ((a+b)/2)) {
                a = a;
                b = (a+b)/2;
            } else if (y > (a+b)/2) {
                a = (a+b)/2;
                b = b;
            } else {
                return f_1((a-b)/2);
            }
        }
        return f_1((a+b)/2);
    }

    public static String unstetige_funktion_easy() {
        return "f(x) = for (x <0,5) : 0; else: 1";
    }



}


