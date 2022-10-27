package injectors;

import parser.Parser;

public interface ParserServiceInjector<T,V> {

    Parser<T,V> getParser();

}
