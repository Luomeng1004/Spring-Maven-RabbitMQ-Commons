package com.imwoniu.rabbitmq;


import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * 生产者
 */
public class Producer extends EndPoint {


    public Producer(String endPointName) throws IOException {
        super(endPointName);
    }

    public void sendMessage(Serializable object) throws IOException {

        channel.basicPublish("", endPointName, null, SerializationUtils.serialize(object));

    }
}
