package com.mycompany.sertest;

import com.mycompany.sertest.dto.SimpleDataObject;

/**
 *
 * @author nirro
 */
public abstract class PerformanceTestBase
{
    protected static final int DUMMY_ID = 12;

    protected static final String DUMMY_MESSAGE = "message";

    protected static final String[] DUMMY_DATA = new String[]{"mac os", "linux", "windows"};

    protected static final SimpleDataObject OBJECT_TO_TRANSFORM =
            new SimpleDataObject(DUMMY_ID, DUMMY_MESSAGE, DUMMY_DATA, DUMMY_ID);

}
