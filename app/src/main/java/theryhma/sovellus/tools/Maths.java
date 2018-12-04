package theryhma.sovellus.tools;

public class Maths {


    public static int getRandomIntegerBetweenRange(int min, int max){
        int x = (int)(java.lang.Math.random()*((max-min)+1))+min;
        return x;
    }

    public static double getRandomDoubleBetweenRange(double min, double max){
        double x = (Math.random()*((max-min)+1))+min;
        return x;
    }

    public static boolean isZero(double value, double threshold){
        return value >= -threshold && value <= threshold;
    }
}
