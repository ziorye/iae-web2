package day0901.demo;

public interface Animal {
    String a ();
    String b ();

    default String c() {
        return null;
    }
}
