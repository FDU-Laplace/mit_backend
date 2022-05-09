package com.missiongroup.starring.modular.vhis.data.websocket;

import com.missiongroup.starring.modular.system.controller.LineDataController;
import com.missiongroup.starring.modular.vhis.data.websocket.consistenthash.ConsistentHashRouter;
import com.missiongroup.starring.modular.vhis.data.websocket.consistenthash.GetNodes;
import com.missiongroup.starring.modular.vhis.data.websocket.consistenthash.MyServiceNode;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    private ConsistentHashRouter<MyServiceNode> consistentHashRouter;

    public List<TrainInfo> getFromDB(String tid) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if(tid == null){
            tid = "001";
        }
        List<TrainInfo> list=new ArrayList<TrainInfo>();


        String dirver="com.mysql.jdbc.Driver";
        String user="spark";
        //xiugai  String user = "root";
        String psd="123456";
        String database="mit_vhis";
        //System.out.println("###########tid=" + tid);
        if("701".equals(tid)){
            tid = "001";
            //tid = "005";

        }
        if("702".equals(tid)){
            tid = "020";
        }
        if("703".equals(tid)){
            //tid = "001";
            tid = "002";
        }
        if("704".equals(tid)){
            tid = "010";
        }
        if("705".equals(tid)){
            tid = "004";
        }
        if("706".equals(tid)){
            tid = "013";
        }
        System.out.println("dbutil-------48hang");
        GetNodes gn = new GetNodes();
        List<MyServiceNode> nodeList = gn.getnodes();
        consistentHashRouter = new ConsistentHashRouter<>(nodeList, 128);//20 virtual node
        System.out.println("dbutil-------52hang");
        //拿到索引ip
        String ip = consistentHashRouter.routeNode(tid).getKey();
        String tablename1="train"+tid+"_data_latest1";
        String tablename2="train"+tid+"_data_latest2";
        String tablename3="train"+tid+"_data_latest3";
        String tablename4="train"+tid+"_data_latest4";
        String tablename5="train"+tid+"_data_latest5";
        String tablename6="train"+tid+"_data_latest6";
        String url="jdbc:mysql://"+ip+":3306/ddu_socket?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true" + "&user=" + user + "&password=" + psd;
        Connection conn= DriverManager.getConnection(url);
        Statement stat=conn.createStatement();
        String sql1="select * from "+tablename1;
        String sql2="select * from "+tablename2;
        String sql3="select * from "+tablename3;
        String sql4="select * from "+tablename4;
        String sql5="select * from "+tablename5;
        String sql6="select * from "+tablename6;
        System.out.println("dbutil-------70hang");

        ResultSet rs1 = stat.executeQuery(sql1);
        while (rs1.next()){
            TrainInfo trainInfo=new TrainInfo( rs1.getString(1), rs1.getString(2));
            list.add(trainInfo);
        }
        rs1.close();

        ResultSet rs2 = stat.executeQuery(sql2);
        while (rs2.next()){
            TrainInfo trainInfo=new TrainInfo( rs2.getString(1), rs2.getString(2));
            list.add(trainInfo);
        }
        rs2.close();

        ResultSet rs3 = stat.executeQuery(sql3);
        while (rs3.next()){
            TrainInfo trainInfo=new TrainInfo( rs3.getString(1), rs3.getString(2));
            list.add(trainInfo);
        }
        rs3.close();

        ResultSet rs4 = stat.executeQuery(sql4);
        while (rs4.next()){
            TrainInfo trainInfo=new TrainInfo( rs4.getString(1), rs4.getString(2));
            list.add(trainInfo);
        }
        rs4.close();

        ResultSet rs5 = stat.executeQuery(sql5);
        while (rs5.next()){
            TrainInfo trainInfo=new TrainInfo( rs5.getString(1), rs5.getString(2));
            list.add(trainInfo);
        }
        rs5.close();

        ResultSet rs6 = stat.executeQuery(sql6);
        while (rs6.next()){
            TrainInfo trainInfo=new TrainInfo( rs6.getString(1), rs6.getString(2));
            list.add(trainInfo);
        }
        rs6.close();

        stat.close();
        conn.close();
        return list;
    }

}