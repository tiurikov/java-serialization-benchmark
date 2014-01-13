package com.mycompany.sertest;

import com.mycompany.sertest.common.PerformanceTestBase;
import com.mycompany.sertest.dto.SimpleDataObject;
import org.msgpack.MessagePack;


/**
 * Created by dart on 13.01.14.
 */
public class MsgPackTest extends PerformanceTestBase {

    MessagePack msgPack = new MessagePack();

    public MsgPackTest() {
        super();
        msgPack.register(SimpleDataObject.class);
    }

    @Override
    public byte[] serialize(SimpleDataObject object) throws Exception {

        return msgPack.write(object);
    }

    @Override
    public SimpleDataObject deserialize(byte[] data) throws Exception {

        return msgPack.read(data, SimpleDataObject.class);
    }
}
