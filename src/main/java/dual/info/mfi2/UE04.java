package dual.info.mfi2;

import java.sql.SQLOutput;

public class UE04 {

    private static float f_1(float y) {
        return (float) Math.sqrt(y);
    }

    public static float locate_y_value(float y, float a, float b) {
        float konstante = 0.1f;

        if(Math.abs(a - b) < konstante)
            return f_1(y);
        float halb = (a + b) / 2;
        if(y > halb) {
            return locate_y_value(y, halb, b);
        } else {
            return locate_y_value(y, a, halb);
        }
    }

    public static void main(String[] args) {
        int a = 0;
        int b = 5;
        float y = 3.6f;
        System.out.println(locate_y_value(y, a, b));
        System.out.println(locate_y_value_iterativ(y,a,b));
    }

    public static float locate_y_value_iterativ(float y, float a, float b) {
        float konstante = 0.1f;
        while(Math.abs(a-b) > konstante) {
            if(y < f_1((a-b)/2)) {
                a = a;
                b = f_1((a-b)/2);
            } else if (y > f_1((a-b)/2)) {
                a = f_1((a-b)/2);
                b = b;
            } else {
                return f_1((a+b)/2);
            }
        }
        return f_1((a+b)/2);
    }

    public static String unstetige_funktion_easy() {
        return "f(x) = for (x <0,5) : 0; else: 1";
    }


}


