package bagian10.test;

import org.junit.jupiter.api.Test;

public class LifeCycleTest { // independent

    private String temp;

    @Test
    void testA() {
        temp = "Aera";
    }

    @Test
    void testB() {
        System.out.println(temp);
    }
}
