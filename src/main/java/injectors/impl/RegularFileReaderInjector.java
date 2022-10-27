package injectors.impl;

import injectors.IOServiceInjector;
import io.ReadableFile;
import io.impl.RegularFileReader;

public class RegularFileReaderInjector implements IOServiceInjector<String> {

    @Override
    public ReadableFile<String> getReader() {
        return new RegularFileReader();
    }
}
