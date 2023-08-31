package day0830;

import com.iae.IaeCaptcha;

public class TestCaptcha {
    public static void main(String[] args) {
        IaeCaptcha iaeCaptcha = new IaeCaptcha(300, 200, 5);
        System.out.println(iaeCaptcha.out());
    }
}
