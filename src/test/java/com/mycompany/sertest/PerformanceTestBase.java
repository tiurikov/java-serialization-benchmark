package com.mycompany.sertest;

import com.mycompany.sertest.dto.SimpleDataObject;
import org.testng.annotations.Test;

/**
 *
 * @author nirro
 */
public abstract class PerformanceTestBase
{
    private static final SimpleDataObject OBJECT_TO_TRANSFORM =
            new SimpleDataObject(12, "message", new String[]{"mac os", "linux", "windows"}, 34);

    private static final long EXECUTION_COUNT = 500000;

    @Test
    public void transformTest() throws Exception
    {
        final long startTime = System.currentTimeMillis();

        for (int i = 0; i < EXECUTION_COUNT; i++) {
            transform(OBJECT_TO_TRANSFORM);
        }

        final long executionTime = System.currentTimeMillis() - startTime;
        final double processingSpeed = EXECUTION_COUNT / (executionTime / 1000d);

        System.out.printf("%12s Time: %4s, Speed: %8.2f p/sec\n",
                this.getClass().getSimpleName(), executionTime, processingSpeed);
    }

    public abstract void transform(SimpleDataObject object) throws Exception;
}
