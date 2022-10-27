package consumer;


import injectors.InterpreterServiceInjector;
import injectors.impl.AggregationInterpreterInjector;
import operations.Interpreter;

import java.util.Queue;


public class StringConsumer extends Thread{

    private final Queue<String[]> dataQueue;
    private final int maxSize;

    private final InterpreterServiceInjector<String> interpreterServiceInjector;

    public StringConsumer(Queue queue, int maxSize)
    {
        this.dataQueue = queue;
        this.maxSize = maxSize;

        this.interpreterServiceInjector = new AggregationInterpreterInjector();
    }

    @Override
    public void run() {

        Interpreter<String> interpreter
                = this.interpreterServiceInjector.getInterpreter();

        while (true) {
            synchronized (dataQueue) {
                /*if data queue is empty, consumer thread will be waited*/
                while (dataQueue.isEmpty()) {
                    try {
                        dataQueue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                String[] parsedAndCleanedLine = dataQueue.poll();

                if(parsedAndCleanedLine.length < 3) {
                    break;
                }

                interpreter.interpret(parsedAndCleanedLine);
                dataQueue.notifyAll();

            }
        }

        System.out.println(interpreter.toString());

    }
}
