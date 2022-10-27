import consumer.StringConsumer;
import producer.ReadFileProducer;

import java.util.LinkedList;
import java.util.Queue;

public class Application {
    public static void main(String[] args) {

        Queue<String> sharedQ = new LinkedList<>();

        ReadFileProducer p = new ReadFileProducer("src/main/resources/records",sharedQ,5);
        StringConsumer c = new StringConsumer(sharedQ,5);
        p.start();
        c.start();

    }

}
