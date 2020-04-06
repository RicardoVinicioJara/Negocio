/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import java.sql.DriverManager;

/**
 *
 * @author FERNANDO
 */
public class Conexion {
    com.mysql.jdbc.Connection con;

    public com.mysql.jdbc.Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/negocio","root","");
        } catch (Exception e) {
        }
        return con;
    }
}
