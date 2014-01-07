package com.mycompany.sertest;

import com.mycompany.sertest.dto.SimpleDataObject;
import com.mycompany.sertest.thrift.SimpleThriftStruct;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

public class ThriftTest extends PerformanceTestBase
{
    private final TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
    private final TDeserializer deserializer = new TDeserializer(new TBinaryProtocol.Factory());

    @Override
    public void transform(SimpleDataObject object) throws Exception
    {
        final SimpleThriftStruct simpleInStruct =
                new SimpleThriftStruct(object.getParentId(), object.getMessage(), object.getSomeId());

        deserializer.deserialize(new SimpleThriftStruct(), serializer.serialize(simpleInStruct));
    }
}