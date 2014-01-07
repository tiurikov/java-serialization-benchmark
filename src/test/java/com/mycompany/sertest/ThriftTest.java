package com.mycompany.sertest;

import com.mycompany.sertest.common.PerformanceTestBase;
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
    public byte[] serialize(SimpleDataObject object) throws Exception
    {
        final SimpleThriftStruct simpleInStruct =
                new SimpleThriftStruct(
                    object.getParentId(),
                    object.getMessage(),
                    object.getData(),
                    object.getSomeId());

        return serializer.serialize(simpleInStruct);
    }

    @Override
    public SimpleDataObject deserialize(byte[] data) throws Exception
    {
        final SimpleThriftStruct simpleThriftStruct = new SimpleThriftStruct();

        deserializer.deserialize(simpleThriftStruct, data);

        return new SimpleDataObject(
                simpleThriftStruct.getSomeId(),
                simpleThriftStruct.getMessage(),
                simpleThriftStruct.getData(),
                simpleThriftStruct.getParentId());
    }
}