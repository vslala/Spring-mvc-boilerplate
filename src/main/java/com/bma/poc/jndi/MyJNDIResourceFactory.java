package com.bma.poc.jndi;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

public class MyJNDIResourceFactory implements ObjectFactory {
    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        Reference referencedObject = (Reference) obj;
        MyJNDIResource myJNDIResource = new MyJNDIResource();
        myJNDIResource.setPersonName(referencedObject.get("personName").getContent().toString());
        myJNDIResource.setMessage(referencedObject.get("message").getContent().toString());
        return myJNDIResource;
    }
}
