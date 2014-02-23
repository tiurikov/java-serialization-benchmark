package com.mycompany.sertest;

import com.mycompany.sertest.common.PerformanceTestBase;
import com.mycompany.sertest.dto.SimpleDataObject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.xml.bind.*;

/**
 *
 * @author nirro
 */
public class JaxbTest extends PerformanceTestBase
{
    private final JAXBContext context;
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    
    private JaxbTest() throws JAXBException {
        context = JAXBContext.newInstance(SimpleDataObject.class);
        marshaller = context.createMarshaller();
        unmarshaller = context.createUnmarshaller();
    }
    
    @Override
    public byte[] serialize(SimpleDataObject object) throws Exception
    {
        baos.reset();
        
        marshaller.marshal(object, baos);
        
        return baos.toByteArray();
    }

    @Override
    public SimpleDataObject deserialize(byte[] data) throws Exception
    {
        return (SimpleDataObject) unmarshaller.unmarshal(new ByteArrayInputStream(data));
    }
    
}
