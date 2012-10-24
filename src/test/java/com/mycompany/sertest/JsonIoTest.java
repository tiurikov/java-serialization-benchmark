package com.mycompany.sertest;

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 *
 * @author Admin
 */
public class JsonIoTest extends PerformanceTestBase
{
    @Test
    public void JsonIo100000TransformationsRun() throws IOException {
        final long time = System.currentTimeMillis();

        for (int i = 0; i < EXECUTION_COUNT_100000; i++) {
            final String json = JsonWriter.toJson(OBJECT_TO_TRANSFORM);
            JsonReader.jsonToJava(json);
        }

        System.out.println("JsonIo-100000 Time = " + (System.currentTimeMillis() - time));
    }
}
