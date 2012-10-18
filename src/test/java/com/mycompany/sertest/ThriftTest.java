package com.mycompany.sertest;

import com.mycompany.sertest.thrift.SimpleThriftStruct;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.testng.annotations.Test;

public class ThriftTest
{
    public static final int DUMMY_ID = 12;
    public static final int DUMMY_PARENT_ID = 34;


    @Test
    public void thrift100000()
    {
        final long time = System.currentTimeMillis();

        final SimpleThriftStruct simpleInStruct = new SimpleThriftStruct(DUMMY_PARENT_ID, "message", DUMMY_ID);
        final TSerializer _serializer = new TSerializer(new TBinaryProtocol.Factory());
        final TDeserializer _deserializer = new TDeserializer(new TBinaryProtocol.Factory());

        for (int i = 0; i < 100000; i++) {

            try {
                final byte[] _bytes = _serializer.serialize(simpleInStruct);
                _deserializer.deserialize(new SimpleThriftStruct(), _bytes);
            } catch (TException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thrift-10000 Time = " + (System.currentTimeMillis() - time));
    }
}