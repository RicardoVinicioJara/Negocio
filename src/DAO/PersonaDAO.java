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
public class PersonaDAO {

    Conexion con = new Conexion();
    Connection coneccion;

    public PersonaDAO() {
        coneccion = con.getConnection();
    }
    public int maxId() {
        try {
            String sql = "SELECT MAX(id ) FROM persona";
            Statement se = coneccion.createStatement();
            ResultSet seter = se.executeQuery(sql);
            while (seter.next()) {
                return  seter.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage() + e.getErrorCode());
            return 0;
        }
        return 0;
    }

    public boolean ingresar(Persona persona) {
        try {
            String Query = "INSERT INTO persona(CEDULA,NOMBRE)values(?,?) ";
            PreparedStatement statement = coneccion.prepareStatement(Query);

            statement.setString(1, persona.getCedula());
            statement.setString(2, persona.getNombre());
            statement.execute();
            //coneccion.commit();

            return true;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage() + e.getErrorCode());
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            String Query = "DELETE from persona WHERE ID = '" + id + "'";
            Statement se = (Statement) coneccion.createStatement();
            se.executeUpdate(Query);
            //coneccion.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
            return false;
        }
    }

    public boolean actualizar(Persona persona) {
        try {
            String Query = "UPDATE persona SET CEDULA = ?,NOMBRE = ? WHERE ID = " + persona.getId();
            PreparedStatement statement = coneccion.prepareStatement(Query);

            statement.setString(1, persona.getCedula());
            statement.setString(2, persona.getNombre());
            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR ACT: " + e);
            return false;
        }
    }

    public List<Persona> listar() {
        List<Persona> lista = new ArrayList<>();
        String sql = "select * from persona";
        try {
            Statement se = coneccion.createStatement();
            ResultSet seter = se.executeQuery(sql);
            while (seter.next()) {
                int id = seter.getInt(1);
                String cedula = seter.getString(2);
                String nombre = seter.getString(3);
                sql = "select * from telefono where persona_id = " + id;
                Statement se1 = coneccion.createStatement();
                ResultSet seter1 = se1.executeQuery(sql);
                List<Telefono> listaTelefonos = new ArrayList<>();
                while (seter1.next()) {
                    int id1 = seter1.getInt(1);
                    String numero = seter1.getString(2);
                    String tipo = seter1.getString(3);
                    Telefono t = new Telefono(id1, numero, tipo, id);
                    listaTelefonos.add(t);
                }
                Persona p = new Persona(id, cedula, nombre, listaTelefonos);
                lista.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Error de lectura :" + ex.getMessage());
        }
        return lista;
    }

    public Persona buscar(int idb) {
        String sql = "select * from persona where id = '" + idb + "'";
        Persona persona = null;
        try {
            Statement se = coneccion.createStatement();
            ResultSet seter = se.executeQuery(sql);
            while (seter.next()) {
                int id = seter.getInt(1);
                String cedula = seter.getString(2);
                String nombre = seter.getString(3);
                sql = "select * from telefono where persona_id = " + id;
                Statement se1 = coneccion.createStatement();
                ResultSet seter1 = se1.executeQuery(sql);
                List<Telefono> listaTelefonos = new ArrayList<>();
                while (seter1.next()) {
                    int id1 = seter1.getInt(1);
                    String numero = seter1.getString(2);
                    String tipo = seter1.getString(3);
                    Telefono t = new Telefono(id1, numero, tipo, id);
                    listaTelefonos.add(t);
                }
                 persona = new Persona(id, cedula, nombre, listaTelefonos);
                
            }
        } catch (SQLException ex) {
            System.out.println("Error de busqueda :" + ex.getMessage());
        }
        return persona;
    }

    public Persona buscarCedula(String ced) {
        String sql = "select * from persona where CEDULA = '" + ced + "'";
        Persona persona = null;
        try {
            Statement se = coneccion.createStatement();
            ResultSet seter = se.executeQuery(sql);
            while (seter.next()) {
                int id = seter.getInt(1);
                String cedula = seter.getString(2);
                String nombre = seter.getString(3);
                sql = "select * from telefono where persona_id = " + id;
                Statement se1 = coneccion.createStatement();
                ResultSet seter1 = se1.executeQuery(sql);
                List<Telefono> listaTelefonos = new ArrayList<>();
                while (seter1.next()) {
                    int id1 = seter1.getInt(1);
                    String numero = seter1.getString(2);
                    String tipo = seter1.getString(3);
                    Telefono t = new Telefono(id1, numero, tipo, id);
                    listaTelefonos.add(t);
                }
                 persona = new Persona(id, cedula, nombre, listaTelefonos);
                
            }
        } catch (SQLException ex) {
            System.out.println("Error de busqueda cedula :" + ex.getMessage());
        }
        return persona;
    }

    

}
