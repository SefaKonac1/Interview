package injectors.impl;

import injectors.InterpreterServiceInjector;
import operations.Interpreter;
import operations.impl.AggregationInterpreter;

public class AggregationInterpreterInjector implements InterpreterServiceInjector<String> {

    @Override
    public Interpreter<String> getInterpreter() {
        return new AggregationInterpreter();
    }
}
