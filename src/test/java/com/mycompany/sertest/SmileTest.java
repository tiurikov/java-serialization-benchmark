package com.mycompany.sertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.smile.SmileFactory;
import com.mycompany.sertest.dto.SimpleDataObject;

/**
 *
 * @author nirro
 */
public class SmileTest extends PerformanceTestBase
{
    private final ObjectMapper mapper = new ObjectMapper(new SmileFactory());

    @Override
    public void transform(SimpleDataObject object) throws Exception
    {
        mapper.readValue(mapper.writeValueAsBytes(object), SimpleDataObject.class);
    }
}