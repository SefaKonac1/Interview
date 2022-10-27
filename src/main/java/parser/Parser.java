package parser;

public interface Parser<T,U> {
    T parse(U rawResource);
}
