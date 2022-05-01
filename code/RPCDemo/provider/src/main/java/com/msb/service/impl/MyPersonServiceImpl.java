package com.msb.service.impl;

import com.msb.pojo.Person;
import com.msb.service.MyPersonService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IBM on 2020/9/14.
 */
public class MyPersonServiceImpl extends UnicastRemoteObject implements MyPersonService {


    public MyPersonServiceImpl() throws RemoteException {
    }

    public List<Person> findAll() throws RemoteException {

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person(1,"张三丰"));
        personList.add(new Person(2 , "张无忌"));

        return personList;
    }
}
