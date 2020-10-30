package com.mydeveloperplanet.mygoogleappengineplanet.mygoogleappengineplanet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import com.google.dao.MysqlDataObject;
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        StringBuilder message = new StringBuilder("Hello Google App Engine!");
        try {
            InetAddress ip = InetAddress.getLocalHost();
           List l= MysqlDataObject.getConnectionObject("Pradeep Chinnapaih");
            message.append(" From host: Host Name:: " + ip.getHostName()+" Host Address."+ip.getHostAddress()+"Printing User object"+l);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return message.toString();
    }

}
