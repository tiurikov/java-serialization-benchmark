package com.mycompany.sertest;

import com.mycompany.sertest.dto.SimpleDataObject;
import com.thoughtworks.xstream.XStream;

public class XStreamTest extends PerformanceTestBase
{
    private final XStream stream = new XStream();

    @Override
    public void transform(SimpleDataObject object)
    {
        stream.fromXML(stream.toXML(object));
    }
}