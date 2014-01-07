package com.mycompany.sertest;

import com.google.gson.Gson;
import com.mycompany.sertest.dto.SimpleDataObject;


/**
 *
 * @author Admin
 */
public class GsonTest extends PerformanceTestBase
{
    private final Gson gson = new Gson();

    @Override
    public void transform(SimpleDataObject object)
    {
        gson.fromJson(gson.toJson(object), SimpleDataObject.class);
    }
}
