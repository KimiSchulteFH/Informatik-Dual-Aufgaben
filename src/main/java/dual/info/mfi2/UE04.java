package dual.info.mfi2;

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
    }

}
