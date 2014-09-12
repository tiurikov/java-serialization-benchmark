package com.mycompany.sertest;

import com.mycompany.sertest.common.PerformanceTestBase;
import com.mycompany.sertest.dto.SimpleDataObject;
import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;

/**
 *
 * @author nirro
 */
public class BoonJsonTest extends PerformanceTestBase
{
    private final ObjectMapper objectMapper = JsonFactory.create();

    @Override
    public byte[] serialize(SimpleDataObject object) throws Exception
    {
        return objectMapper.writeValueAsBytes(object);
    }

    @Override
    public SimpleDataObject deserialize(byte[] data) throws Exception
    {
        return objectMapper.readValue(data, SimpleDataObject.class);
    }
}
