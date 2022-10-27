package parser.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.Parser;

class StringParserTest {

    private final Parser<String[], String> parser;
    private static final String[] testCases =
            {
                    "a0545486,PAYMENT,WITHDRAW",
                    "a0545486, ADVICE,                         FAIL",
                    "a0545480        , PAYMENT    , SUCCESS",
                    "a0545480 ,                PAYMENT       , FAIL       ",
                    "b0545483  ,             PAYMENT , SUCCESS       ",
                    "d05c5480 , ADVICE, WITHDRAW",
                    "d05g5480 , PAYMENT, FAIL",
                    "       e05f5483   , ADVICE,     WITHDRAW          ",
            };

    private static final String[][] expectedOutputOfTestCases =
            {
                    {"a0545486","PAYMENT","WITHDRAW"},
                    {"a0545486","ADVICE","FAIL"},
                    {"a0545480","PAYMENT","SUCCESS"},
                    {"a0545480","PAYMENT","FAIL"},
                    {"b0545483","PAYMENT","SUCCESS"},
                    {"d05c5480","ADVICE","WITHDRAW"},
                    {"d05g5480","PAYMENT","FAIL"},
                    {"e05f5483","ADVICE","WITHDRAW"},

            };

    public StringParserTest(){
        parser = new StringWithSeparatedByCommaParser();
    }

    @Test
    void stringParserTest_WithCommaDelimiterOption() {

        for (int i = 0 ; i < testCases.length ; i++) {
            Assertions.assertArrayEquals(expectedOutputOfTestCases[i],
                    parser.parse(testCases[i]));
        }

    }
}