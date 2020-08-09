package com.bma.poc.hello;

import com.bma.poc.jndi.MyJNDIResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Controller
//@RequestMapping("/gap")
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "hello";
    }

    @RequestMapping(value = "/example/jndi", method = RequestMethod.GET)
    @ResponseBody
    public String helloFromJNDIWorld() throws NamingException {
        Context initialContext = new InitialContext();
        Context envContext = (Context) initialContext.lookup("java:comp/env");
        MyJNDIResource jndiResource = (MyJNDIResource) envContext.lookup("HelloJndi");
        return jndiResource.getPersonName() + " wants to say " + jndiResource.getMessage();
    }
}
