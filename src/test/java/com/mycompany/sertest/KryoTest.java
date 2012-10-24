package com.mycompany.sertest;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.mycompany.sertest.dto.SimpleDataObject;
import org.testng.annotations.Test;

/**
 *
 * @author dart
 */
public class KryoTest extends PerformanceTestBase
{
    @Test
    public void kryo100000TransformationsRun()
    {
        final long time = System.currentTimeMillis();


        for (int i = 0; i < EXECUTION_COUNT_100000; i++) {

           byte[] result = KryoSerializer.write(OBJECT_TO_TRANSFORM);
           KryoSerializer.read(result);
        }

        System.out.println("Kryo-100000 Time = " + (System.currentTimeMillis() - time));
    }


}


