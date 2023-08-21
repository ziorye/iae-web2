package day0821;

import java.util.Random;

public class IaeRandom {
    public static void main(String[] args) {
        String[] names = new String[] {"H", "Z"};
        int random = new Random().nextInt(names.length);
        System.out.println(names[random]);
    }
}
