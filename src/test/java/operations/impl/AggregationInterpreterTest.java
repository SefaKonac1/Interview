package operations.impl;

import operations.Interpreter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;


class AggregationInterpreterTest {

    private final Interpreter<String> interpreter;

    private static final String[][] aggregationInterpreterTestCase = {
            {"a0sda45", "PAYMENT", "PASS"},
            {"a453fb8", "PAYMENT", "FAIL"},
            {"a453fb6", "PAYMENT", "FAIL"},
            {"a4236b0", "PAYMENT", "WITHDRAW"},
            {"a4236b0", "ADVICE", "WITHDRAW"},
            {"a4236b0", "ADVICE", "WITHDRAW"},
            {"a4236b0", "ADVICE", "PASS"},
            {"a4236b0", "ADVICE", "PASS"},

    };

    private static final String expectedStatistics = "PAYMENT WITHDRAW 1 PASS 1 FAIL 2\n" +
            "ADVICE WITHDRAW 2 PASS 2";

     AggregationInterpreterTest() {
        interpreter = new AggregationInterpreter();
     }

    @Test
    public void AggregationInterpreterTest_withDifferentStringInputs() {

         for (String[] line : aggregationInterpreterTestCase) {
             interpreter.interpret(line);
         }
         
         Assertions.assertEquals(expectedStatistics, interpreter.toString());
    }

}