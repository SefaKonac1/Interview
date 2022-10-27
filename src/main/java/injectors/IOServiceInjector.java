package injectors;

import io.ReadableFile;

public interface IOServiceInjector<T> {
    public ReadableFile<T> getReader();
}
