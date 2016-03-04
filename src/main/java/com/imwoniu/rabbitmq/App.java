package com.imwoniu.rabbitmq;

import java.util.HashMap;

/**
 * Created by Work on 2016/3/4.
 */
public class App {
    public App() throws Exception {

        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        Producer producer = new Producer("queue");
        for (int i = 0; i < 10000; i++) {
            HashMap message = new HashMap();
            message.put("message number", i);
            producer.sendMessage(message);
            System.out.println("Message Number "+ i +" sent.");
        }
    }

    public static void main (String[] args) throws Exception {
        new App();
    }
}
