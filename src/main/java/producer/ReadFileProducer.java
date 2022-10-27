package producer;

import injectors.IOServiceInjector;
import injectors.ParserServiceInjector;
import injectors.impl.RegularFileReaderInjector;
import injectors.impl.StringWithSeparatedByCommaParserInjector;
import io.ReadableFile;
import parser.Parser;


import java.util.Optional;
import java.util.Queue;


/*
*  This Class is responsible for reading lines from file and parse them into
*  String array and send them to consumer.
* */

public class ReadFileProducer extends Thread{

    private final Queue<String[]> dataQueue;
    private final int maxSize;

    private final IOServiceInjector<String> ioServiceInjector;
    private final ParserServiceInjector<String[], String> parserServiceInjector;
    private final String resource;

    public ReadFileProducer(String resource, Queue queue, int maxSize) {

        this.resource = resource;
        this.dataQueue = queue;
        this.maxSize = maxSize;

        this.ioServiceInjector = new RegularFileReaderInjector();
        this.parserServiceInjector = new StringWithSeparatedByCommaParserInjector();
    }

    @Override
    public void run() {

        ReadableFile<String> readableFile = ioServiceInjector.getReader();

        Parser<String[], String> parser = parserServiceInjector.getParser();

        /*opens file*/
        readableFile.openResource(Optional.of(resource));

        /*starts to read file*/
        Optional<String> line = readableFile.read();
        String[] parsedStrings = parser.parse(line.toString());
        dataQueue.add(parsedStrings);

        while (line.isPresent()) {

            synchronized (dataQueue) {

                while (maxSize == dataQueue.size()) {
                    try {
                        dataQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                /*reads line from file */
                line = readableFile.read();

                /*parses line into string array*/
                parsedStrings = parser.parse(line.toString());
                dataQueue.add(parsedStrings);
                dataQueue.notifyAll();



            }
        }

    }

}
