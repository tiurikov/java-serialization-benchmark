package com.mycompany.sertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.sertest.common.PerformanceTestBase;
import com.mycompany.sertest.dto.SimpleDataObject;

/**
 *
 * @author tyurikov
 */
public class JacksonTest extends PerformanceTestBase
{
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public byte[] serialize(SimpleDataObject object) throws Exception
    {
        return mapper.writeValueAsString(object).getBytes();
    }

    @Override
    public SimpleDataObject deserialize(byte[] data) throws Exception
    {
        return mapper.readValue(data, SimpleDataObject.class);
    }
}
