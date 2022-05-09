package com.missiongroup.starring.modular.vhis.data.websocket.consistenthash;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*
 * get nodes from database
 * check the node status and adjust the hash loop dynamically
 *
 */

public class GetNodes {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://10.176.25.26:3306/nodes?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    //xiugai static final String DB_URL = "jdbc:mysql://192.168.0.122:3306/nodes?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "spark";
    //static final String USER = "root";
    static final String PASS = "123456";
    public GetNodes(){}
    public List<MyServiceNode> getnodes() {
        Connection conn = null;
        Statement stmt = null;
        List<MyServiceNode> nodes = new ArrayLisxiu gat<MyServiceNode>();
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM physical_nodes";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String ip = rs.getString("IP");
                int usable = rs.getInt("usable");
                if (usable == 1) {
                    MyServiceNode newnode = new MyServiceNode(ip);
                    nodes.add(newnode);
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
        return nodes;
    }
}