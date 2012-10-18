/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sertest.dto;

/**
 *
 * @author Admin
 */
public class SimpleDataObject extends SimpleDataObjectParent
{
    private long someId;
    private String message;


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
}
