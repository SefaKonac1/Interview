package operations;

import java.util.Optional;

public interface Interpreter<T> {

    void interpret(T... parsedResource);
}
