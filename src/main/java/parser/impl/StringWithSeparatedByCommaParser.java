package parser.impl;

import com.sun.istack.internal.NotNull;
import parser.Parser;

public class StringWithSeparatedByCommaParser implements Parser<String[], String> {
    @Override
    public String[] parse(@NotNull String rawResource) {

        /*to get rid of whitespaces around items' addition to parsing by commas */
        return rawResource.trim().split("\\s*,\\s*");
    }
}
