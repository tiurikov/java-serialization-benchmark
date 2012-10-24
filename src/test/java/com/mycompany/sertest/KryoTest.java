package com.mycompany.sertest;

import com.google.gson.Gson;
import com.mycompany.sertest.dto.SimpleDataObject;
import org.testng.annotations.Test;

/**
 *
 * @author Admin
 */
public class KryoTest extends PerformanceTestBase
{
    @Test
    public void gson100000TransformationsRun()
    {
        final long time = System.currentTimeMillis();
        final Gson gson = new Gson();

        for (int i = 0; i < EXECUTION_COUNT_100000; i++) {
            final String json = gson.toJson(OBJECT_TO_TRANSFORM);
            gson.fromJson(json, SimpleDataObject.class);
        }

        System.out.println("Gson-100000 Time = " + (System.currentTimeMillis() - time));
    }
}
