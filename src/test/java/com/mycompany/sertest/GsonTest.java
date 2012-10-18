package com.mycompany.sertest;

import com.google.gson.Gson;
import com.mycompany.sertest.dto.SimpleDataObject;
import org.testng.annotations.Test;

/**
 *
 * @author Admin
 */
public class GsonTest
{
    public static final int DUMMY_ID = 12;
    public static final int DUMMY_PARENT_ID = 34;


    @Test
    public void xstream10000()
    {
        final long time = System.currentTimeMillis();
        final Gson gson = new Gson();

        final SimpleDataObject simpleDataObject = new SimpleDataObject("message", DUMMY_ID, DUMMY_PARENT_ID);

        for (int i = 0; i < 10000; i++) {
            final String json = gson.toJson(simpleDataObject);
            gson.fromJson(json, SimpleDataObject.class);
        }

        System.out.println("Gson-10000 Time = " + (System.currentTimeMillis() - time));
    }
}
