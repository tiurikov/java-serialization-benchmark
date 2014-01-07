package com.mycompany.sertest;

import com.mycompany.sertest.common.KryoSerializer;
import com.mycompany.sertest.common.PerformanceTestBase;
import com.mycompany.sertest.dto.SimpleDataObject;

/**
 *
 * @author dart
 */
public class KryoTest extends PerformanceTestBase
{
    @Override
    public byte[] serialize(SimpleDataObject object) throws Exception
    {
        return KryoSerializer.write(object);
    }

    @Override
    public SimpleDataObject deserialize(byte[] data) throws Exception
    {
        return (SimpleDataObject) KryoSerializer.read(data);
    }
}
