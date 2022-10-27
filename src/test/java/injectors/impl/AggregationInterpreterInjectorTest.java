package injectors.impl;

import injectors.InterpreterServiceInjector;
import operations.Interpreter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AggregationInterpreterInjectorTest {

    @Test
    public void aggregationInterpreterInjectorTest() {

        InterpreterServiceInjector<String> interpreterInjector
                = new AggregationInterpreterInjector();

        Interpreter<String> interpreter = interpreterInjector.getInterpreter();

        Assertions.assertNotNull(interpreter);

    }


}