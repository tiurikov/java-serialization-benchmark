package com.mycompany.sertest.dto;

import java.util.List;

/**
 *
 * @author Admin
 */
public class SimpleDataObject extends SimpleDataObjectParent
{
    private long someId;
    private String message;
    private List<String> data;

    public SimpleDataObject()
    {
    }

    public SimpleDataObject(String message, long someId)
    {
        this.message = message;
        this.someId = someId;
    }

    public SimpleDataObject(String message, long someId, long parentId)
    {
        super(parentId);
        this.message = message;
        this.someId = someId;
    }

    public SimpleDataObject(long someId, String message, List<String> data, long parentId)
    {
        super(parentId);
        this.someId = someId;
        this.message = message;
        this.data = data;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public long getSomeId()
    {
        return someId;
    }

    public void setSomeId(long someId)
    {
        this.someId = someId;
    }

    public void setData(List<String> data)
    {
        this.data = data;
    }

    public List<String> getData()
    {
        return data;
    }
}
