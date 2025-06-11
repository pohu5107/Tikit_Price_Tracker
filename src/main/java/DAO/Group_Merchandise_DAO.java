/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Objects.Group_Merchandise;
import Objects.Price_Records;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author The Anh
 */
public class Group_Merchandise_DAO {
    private Connection conn;
    private static final String url="jdbc:mysql://localhost:3306/tiki";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String dbname = "tiki";
    public Group_Merchandise_DAO (){
        try {
            conn = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addGroup_Merchandise(String ID,String name){
        
        try {
            String sql = "INSERT IGNORE INTO group_merchandise (Group_Merchandise_ID, Merchandise_Name) VALUES (?, ?)";
            PreparedStatement stm= conn.prepareStatement(sql);
            PreparedStatement preStatement = conn.prepareStatement(sql);
            preStatement.setString(1,ID);
            preStatement.setString(2,name);
            preStatement.executeUpdate();
        } catch (Exception ex) {
            
        }
    }
    public ArrayList<Group_Merchandise> getAllGroupMerchandise(){
        ArrayList<Group_Merchandise> Group_Merchandise = new ArrayList<>();
        try {
            PreparedStatement stm= conn.prepareStatement("SELECT * FROM group_merchandise");
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                
                
                String Group_Merchandise_ID = rs.getString("Group_Merchandise_ID");
                String Merchandise_Name = rs.getString("Merchandise_Name");
                
                
                Group_Merchandise group_merchandise= new Group_Merchandise(Group_Merchandise_ID,Merchandise_Name);
                Group_Merchandise.add(group_merchandise);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Group_Merchandise;
    }
}
