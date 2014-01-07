package com.mycompany.sertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.sertest.dto.SimpleDataObject;

/**
 *
 * @author tyurikov
 */
public class JacksonTest extends PerformanceTestBase
{
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void transform(SimpleDataObject object) throws Exception
    {
        mapper.readValue(mapper.writeValueAsString(object), SimpleDataObject.class);
    }
}
