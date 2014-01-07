package com.mycompany.sertest;

import com.mycompany.sertest.common.PerformanceTestBase;
import com.mycompany.sertest.dto.SimpleDataObject;
import com.thoughtworks.xstream.XStream;

public class XStreamTest extends PerformanceTestBase
{
    private final XStream stream = new XStream();

    @Override
    public byte[] serialize(SimpleDataObject object) throws Exception
    {
        return stream.toXML(object).getBytes();
    }

    @Override
    public SimpleDataObject deserialize(byte[]  data) throws Exception
    {
        return (SimpleDataObject) stream.fromXML(new String(data));
    }
}