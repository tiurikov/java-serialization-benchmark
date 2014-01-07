/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sertest.dto;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class SimpleDataObjectParent implements Serializable
{
    private long parentId;


    public SimpleDataObjectParent()
    {
    }


    public SimpleDataObjectParent(long parentId)
    {
        this.parentId = parentId;
    }


    public long getParentId()
    {
        return parentId;
    }


    public void setParentId(long parentId)
    {
        this.parentId = parentId;
    }
}
