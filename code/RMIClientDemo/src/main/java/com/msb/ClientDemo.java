package com.msb;

import com.msb.service.DemoService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by IBM on 2020/9/13.
 */
public class ClientDemo {

    public static void main(String[] args) {

        try {
            DemoService demoService = (DemoService)Naming.lookup("rmi://localhost:8989/demoService");
            String result = demoService.demo("msb");

            System.out.println(result);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }



}