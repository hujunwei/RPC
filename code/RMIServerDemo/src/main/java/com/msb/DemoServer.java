package com.msb;

import com.msb.service.DemoService;
import com.msb.service.impl.DemoServiceImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by IBM on 2020/9/13.
 */
public class DemoServer {


    public static void main(String[] args) {
        try {
            //创建接口实例
            DemoService demoService = new DemoServiceImpl();
            //创建注册表
            LocateRegistry.createRegistry(8989);
            //绑定服务
            Naming.bind("rmi://localhost:8989/demoService",demoService);

            System.out.println("服务器启动成功！");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
