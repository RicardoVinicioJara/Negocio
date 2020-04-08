/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import Utils.MyExpetion;
import java.security.GeneralSecurityException;
import java.sql.DriverManager;

import java.sql.Connection;
/**
 *
 * @author FERNANDO
 */
public class Conexion {
    com.mysql.jdbc.Connection con;

    public Connection getConnection() throws MyExpetion{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/negocio","root","");
        } catch (Exception e) {
             throw new MyExpetion("Error de conexion", e.getCause());
        }
        return con;
    }
}
