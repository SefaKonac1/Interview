package io.impl;

import io.ReadableFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;
class RegularFileReaderTest {

    private final ReadableFile<String> fileReader;

    RegularFileReaderTest() {
        fileReader = new RegularFileReader();
    }

    @Test
    void regularFileReaderTest() throws IOException {

        String file = "src/test/resources/recordsTest";
        fileReader.openResource(Optional.of(file));

        Assertions.assertEquals("a0545486,PAYMENT,WITHDRAW",
                fileReader.read().orElse("VALUE IS NOT PRESENT"));
        Assertions.assertEquals("            a0545486, ADVICE,                         FAIL",
                fileReader.read().orElse("VALUE IS NOT PRESENT"));
        Assertions.assertEquals("a0545480        , PAYMENT    , SUCCESS",
                fileReader.read().orElse("VALUE IS NOT PRESENT"));

        fileReader.close();
    }

}