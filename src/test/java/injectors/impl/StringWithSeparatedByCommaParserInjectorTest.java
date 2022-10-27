package injectors.impl;

import injectors.ParserServiceInjector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.Parser;
import parser.impl.StringWithSeparatedByCommaParser;

import static org.junit.jupiter.api.Assertions.*;

class StringWithSeparatedByCommaParserInjectorTest {

    @Test
    void stringWithSeparatedByCommaParserInjectorTest() {

        ParserServiceInjector<String[], String> parserServiceInjector
                = new StringWithSeparatedByCommaParserInjector();

        Parser<String[], String> stringWithSeparatedByCommaParser
                =  parserServiceInjector.getParser();

        Assertions.assertNotNull(stringWithSeparatedByCommaParser);

    }

}