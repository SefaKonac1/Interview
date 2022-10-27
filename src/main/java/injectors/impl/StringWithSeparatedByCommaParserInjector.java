package injectors.impl;

import injectors.ParserServiceInjector;
import parser.Parser;
import parser.impl.StringWithSeparatedByCommaParser;

public class StringWithSeparatedByCommaParserInjector
        implements ParserServiceInjector<String[], String> {

    @Override
    public Parser<String[], String> getParser() {
        return new StringWithSeparatedByCommaParser();
    }
}
