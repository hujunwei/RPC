package com.msb.service;

import com.msb.pojo.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by IBM on 2020/9/14.
 */
public interface MyPersonService extends Remote {

    public List<Person> findAll() throws RemoteException;

}
