package com.mycompany.sertest;

import com.mycompany.sertest.common.PerformanceTestBase;
import com.mycompany.sertest.dto.SimpleDataObject;
import java.io.*;

/**
 *
 * @author nirro
 */
public class JavaStdTest extends PerformanceTestBase
{
    @Override
    public byte[] serialize(SimpleDataObject object) throws Exception
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(baos);
        outputStream.writeObject(object);
        return baos.toByteArray();
    }

    @Override
    public SimpleDataObject deserialize(byte[] data) throws Exception
    {
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(data));
        return (SimpleDataObject) inputStream.readObject();
    }
}
