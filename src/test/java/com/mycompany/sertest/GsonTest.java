package com.mycompany.sertest;

import com.google.gson.Gson;
import com.mycompany.sertest.common.PerformanceTestBase;
import com.mycompany.sertest.dto.SimpleDataObject;

/**
 *
 * @author Admin
 */
public class GsonTest extends PerformanceTestBase
{
    private final Gson gson = new Gson();

    @Override
    public byte[] serialize(SimpleDataObject object)
    {
        return gson.toJson(object).getBytes();
    }

    @Override
    public SimpleDataObject deserialize(byte[] bytes)
    {
        return gson.fromJson(new String(bytes), SimpleDataObject.class);
    }
}
