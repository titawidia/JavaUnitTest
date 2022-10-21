package bagian10.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {

    @Test
    void testMock() {

        List<String> list = Mockito.mock(List.class); // Object Tiruan

        Mockito.when(list.get(0)).thenReturn("Aera"); // Behavior
        Mockito.when(list.get(100)).thenReturn("Hye Ren");

        System.out.println(list.get(0));
        System.out.println(list.get(100));

        Mockito.verify(list, Mockito.times(1)).get(0);
    }
}
