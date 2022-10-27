package injectors;

import operations.Interpreter;

public interface InterpreterServiceInjector<T> {

    public Interpreter<T> getInterpreter();

}
