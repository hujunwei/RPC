package com.msb.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by IBM on 2020/9/13.
 */
public interface DemoService extends Remote{

    String demo(String param) throws RemoteException;

}
