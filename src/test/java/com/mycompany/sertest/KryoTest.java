package com.mycompany.sertest;

import com.mycompany.sertest.dto.SimpleDataObject;

/**
 *
 * @author dart
 */
public class KryoTest extends PerformanceTestBase
{
    @Override
    public void transform(SimpleDataObject object)
    {
        KryoSerializer.read(KryoSerializer.write(object));
    }
}
