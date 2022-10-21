package bagian10.test;

import bagian10.Calculator;
import bagian10.test.resolver.RandomParameterResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class AbstractCalculatorTest {

    protected Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        System.out.println("Before each");
    }
}
