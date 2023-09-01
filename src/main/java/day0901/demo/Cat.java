package day0901.demo;

public class Cat implements Animal{
    @Override
    public String a() {
        return null;
    }

    @Override
    public String b() {
        return null;
    }

    @Override
    public String c() {
        return Animal.super.c();
    }
}
