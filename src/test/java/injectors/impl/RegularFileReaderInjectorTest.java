package injectors.impl;


import injectors.IOServiceInjector;
import io.ReadableFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RegularFileReaderInjectorTest {

    @Test
    void regularFileReaderInjectorTest() {
        IOServiceInjector<String> ioServiceInjector
                = new RegularFileReaderInjector();

        ReadableFile<String> readableFile = ioServiceInjector.getReader();

        Assertions.assertNotNull(readableFile);


    }

}