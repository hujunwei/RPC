package com.msb.service.impl;

import com.msb.service.DemoService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by IBM on 2020/9/13.
 */
public class DemoServiceImpl extends UnicastRemoteObject implements DemoService {

    public DemoServiceImpl() throws RemoteException
    {}

    public String demo(String param) throws RemoteException {
        return param + " abc";
    }
}
