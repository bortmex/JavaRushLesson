package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector{
    SecurityChecker securityChecker;
    SimpleConnector simpleConnector;

    public SecurityProxyConnector(String text) {
        this.securityChecker = new SecurityCheckerImpl();
        this.simpleConnector = new SimpleConnector(text);
    }


    @Override
    public void connect() {
        if(securityChecker.performSecurityCheck()){
            simpleConnector.connect();
        }
    }
}
