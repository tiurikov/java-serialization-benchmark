package com.mycompany.sertest;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.Test;

public class XStreamTest extends PerformanceTestBase
{
    @Test
    public void xstream100000TransformationsRun()
    {
        final long time = System.currentTimeMillis();
        final XStream stream = new XStream();

        for (int i = 0; i < 100000; i++) {
            final String xml = stream.toXML(OBJECT_TO_TRANSFORM);
            stream.fromXML(xml);
        }

        System.out.println("XStream-10000 Time = " + (System.currentTimeMillis() - time));
    }
}