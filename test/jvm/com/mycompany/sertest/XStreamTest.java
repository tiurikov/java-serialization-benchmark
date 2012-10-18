package com.mycompany.xsteramtest;

import com.mycompany.xsteramtest.dto.SimpleDataObject;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.Test;

public class AppTest
{
    public static final int DUMMY_ID = 12;
    public static final int DUMMY_PARENT_ID = 34;


    @Test
    public void xstream10000()
    {
        final long time = System.currentTimeMillis();
        final XStream stream = new XStream();
        final SimpleDataObject simpleDataObject = new SimpleDataObject("message", DUMMY_ID, DUMMY_PARENT_ID);

        for (int i = 0; i < 10000; i++) {
            final String xml = stream.toXML(simpleDataObject);
            stream.fromXML(xml);
        }

        System.out.println("XStream-10000 Time = " + (System.currentTimeMillis() - time));
    }
}