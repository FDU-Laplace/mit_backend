package com.missiongroup.starring.modular.vhis.data.websocket.consistenthash;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        //initialize 4 service node
        GetNodes gn = new GetNodes();
        List<MyServiceNode> list = gn.getnodes();
        //生成哈希环
        ConsistentHashRouter<MyServiceNode> consistentHashRouter = new ConsistentHashRouter<>(list,128);//20 virtual node


        for(int i=0;i<100;i++)
        {
            System.out.println(consistentHashRouter.routeNode(i+"0").getKey());
        }
    }
}

