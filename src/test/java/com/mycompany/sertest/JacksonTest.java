package com.mycompany.sertest;

import com.mycompany.sertest.dto.SimpleDataObject;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

/**
 *
 * @author tyurikov
 */
public class JacksonTest extends PerformanceTestBase
{
    final ObjectMapper mapper = new ObjectMapper();


    @Test
    public void jackson100000TransformationsRun() throws IOException
    {
        final long time = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            doTransformation(mapper, OBJECT_TO_TRANSFORM);
        }

        System.out.println("Jackson-10000 Time = " + (System.currentTimeMillis() - time));
    }


    @Test
    public void transformationCorrectness() throws IOException
    {
        final SimpleDataObject transformed = doTransformation(mapper, OBJECT_TO_TRANSFORM);

        assertThat(transformed.getMessage(), equalTo(DUMMY_MESSAGE));
    }


    private SimpleDataObject doTransformation(ObjectMapper mapper, SimpleDataObject simpleDataObject) throws IOException
    {
        final String json = mapper.writeValueAsString(simpleDataObject);
        return mapper.readValue(json, SimpleDataObject.class);
    }
}
