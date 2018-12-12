package theryhma.sovellus.tools;

public class Maths {

/** This method returns a random Integer value between the given range.*/
    public static int getRandomIntegerBetweenRange(int min, int max){
        int x = (int)(java.lang.Math.random()*((max-min)+1))+min;
        return x;
    }
}
