package bugs.bug_2_cast_exception;

import java.io.IOException;

public class ClassCastExceptionBug {

    public static void main(String[] args) throws IOException {

        A b = new B();
        if (b instanceof B) {
            b = (B) b;
        }
        System.out.println(b.a);
    }
}

class A {

    int a = 10;

    public void doSomethimg() {
        System.out.println("class A");
    }

}

class B extends A {

    int a = 20;

    public void doSomethimg() {
        System.out.println("class B");
    }

}
