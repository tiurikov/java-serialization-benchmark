package com.mycompany.sertest.common;

import com.mycompany.sertest.dto.SimpleDataObject;
import java.util.ArrayList;
import java.util.Arrays;
import org.testng.annotations.Test;

/**
 *
 * @author nirro
 */
public abstract class PerformanceTestBase
{
    public static final long EXECUTION_COUNT = 1000000;
    public static final SimpleDataObject OBJECT_TO_TRANSFORM =
            new SimpleDataObject(12, "message", new ArrayList(Arrays.asList("mac os", "linux", "windows")), 34);

    @Test
    public void transformTest() throws Exception
    {
        final long startTime = System.currentTimeMillis();

        for (int i = 0; i < EXECUTION_COUNT; i++) {
            deserialize(serialize(OBJECT_TO_TRANSFORM));
        }

        final long executionTime = System.currentTimeMillis() - startTime;
        final double processingSpeed = EXECUTION_COUNT / (executionTime / 1000d);

        System.out.printf("%14s Time: %4s ms, Speed: %8.2f ops/sec, Record Size: %s bytes\n",
                this.getClass().getSimpleName(), executionTime, processingSpeed, serialize(OBJECT_TO_TRANSFORM).length);
    }

    public abstract byte[] serialize(SimpleDataObject object) throws Exception;

    public abstract SimpleDataObject deserialize(byte[] data) throws Exception;
}
