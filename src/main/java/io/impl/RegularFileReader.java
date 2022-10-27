package io.impl;

import io.ReadableFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;


public class RegularFileReader implements ReadableFile<String> {

    private BufferedReader reader;

    @Override
    public void openResource(Optional<String> resource){

        try {
            reader = new BufferedReader(new FileReader(resource.orElse("VALUE IS NOT PRESENT")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Optional<String> read() {
        try {
            String line = reader.readLine();
            if ( line != null) {
                return Optional.of(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
