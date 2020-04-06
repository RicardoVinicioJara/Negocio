/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Persona;
import Entidades.Telefono;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Ricardo
 */
public class TelefonoDAO {

    Conexion con = new Conexion();
    Connection coneccion;

    public TelefonoDAO() {
        coneccion = con.getConnection();
    }

    public boolean ingresar(Telefono telefono) {
        try {
            String Query = "INSERT INTO telefono(NUMERO, TIPO, PERSONA_ID)values(?,?,?) ";
            PreparedStatement statement = coneccion.prepareStatement(Query);

            statement.setString(1, telefono.getNumero());
            statement.setString(2, telefono.getTipo());
            statement.setInt(3, telefono.getPersona_id());
            statement.execute();
            
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR: INS |" + e.getMessage() + e.getErrorCode());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            String Query = "DELETE from telefono WHERE ID = '" + id + "'";
            Statement se = (Statement) coneccion.createStatement();
            se.executeUpdate(Query);
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
            return false;
        }
    }

    public boolean actualizar(Telefono telefono) {
        try {
            String Query = "UPDATE telefono SET NUMERO = ?,TIPO = ? PERSONA_ID ID = " + telefono.getId();
            PreparedStatement statement = coneccion.prepareStatement(Query);

            statement.setString(1, telefono.getNumero());
            statement.setString(2, telefono.getTipo());
            statement.setInt(3, telefono.getId());
            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR ACT: " + e);
            return false;
        }
    }

    public List<Telefono> listar(int id) {
        List<Telefono> lista = new ArrayList<>();
        String sql = "select * from telefono where persona_id = " + id;
        try {
            Statement se1 = coneccion.createStatement();
            ResultSet seter1 = se1.executeQuery(sql);
            while (seter1.next()) {
                int id1 = seter1.getInt(1);
                String numero = seter1.getString(2);
                String tipo = seter1.getString(3);
                Telefono t = new Telefono(id1, numero, tipo, id);
                lista.add(t);
            }

        } catch (SQLException ex) {
            System.out.println("Error de lectura :" + ex.getMessage());
        }
        return lista;
    }

    public Telefono buscar(int idb) {
        String sql = "select * from telefono where id = '" + idb + "'";
        Telefono telefono = null;
        try {
            Statement se1 = coneccion.createStatement();
            ResultSet seter1 = se1.executeQuery(sql);
            while (seter1.next()) {
                int id1 = seter1.getInt(1);
                String numero = seter1.getString(2);
                String tipo = seter1.getString(3);
                 telefono = new Telefono(id1, numero, tipo, idb);
            }

        } catch (SQLException ex) {
            System.out.println("Error de lectura :" + ex.getMessage());
        }
        return telefono;
    }

    public Telefono buscarNumero(String num) {
        String sql = "select * from telefono where numero = '" + num + "'";
        Telefono telefono = null;
        try {
            Statement se1 = coneccion.createStatement();
            ResultSet seter1 = se1.executeQuery(sql);
            while (seter1.next()) {
                int id1 = seter1.getInt(1);
                String numero = seter1.getString(2);
                String tipo = seter1.getString(3);
                int idp = seter1.getInt(4);
                 telefono = new Telefono(id1, numero, tipo, idp);
            }

        } catch (SQLException ex) {
            System.out.println("Error de lectura :" + ex.getMessage());
        }
        return telefono;
    }

}
