package io;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public interface ReadableFile<T> extends Closeable {
    void openResource(Optional<T> resource);
    Optional<T> read();
}
