/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Persona;
import Entidades.Telefono;
import Utils.MyExpetion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
public class PersonaDAO {

    Conexion con = new Conexion();
    Connection coneccion;

    public PersonaDAO() throws MyExpetion {
        try {
            coneccion = con.getConnection();
        } catch (MyExpetion e) {
            throw new MyExpetion("Error de conexion", e.getCause());
        }

    }

    public int maxId() throws MyExpetion {
        try {
            String sql = "SELECT MAX(id ) FROM persona";
            Statement se = coneccion.createStatement();
            ResultSet seter = se.executeQuery(sql);
            while (seter.next()) {
                return seter.getInt(1);
            }
        } catch (SQLException e) {
            throw new MyExpetion("Error MaxID", e.getCause());
        }
        return 0;
    }

    public void ingresar(Persona persona) throws MyExpetion {
        try {
            String Query = "INSERT INTO persona(CEDULA,NOMBRE) values(?,?) ";
            PreparedStatement statement = coneccion.prepareStatement(Query);
            statement.setString(1, persona.getCedula());
            statement.setString(2, persona.getNombre());
            statement.execute();
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1062:
                    throw new MyExpetion("Cedula ya registrada");
                case 1064:
                    throw new MyExpetion("Error en sintax en SQL");
                default:
                    throw new MyExpetion(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new MyExpetion("Erro ingreso Persona", e);
        }
    }

    public void eliminar(int id) throws MyExpetion {
        try {
            String Query = "DELETE from persona WHERE ID = '" + id + "'";
            Statement se = (Statement) coneccion.createStatement();
            se.executeUpdate(Query);
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1064:
                    throw new MyExpetion("Error en sintax en SQL");
                default:
                    throw new MyExpetion(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new MyExpetion("Error eliminar Persona", e);
        }
    }

    public void actualizar(Persona persona) throws MyExpetion {
        try {
            String Query = "UPDATE persona SET CEDULA = ?,NOMBRE = ? WHERE ID = " + persona.getId();
            PreparedStatement statement = coneccion.prepareStatement(Query);

            statement.setString(1, persona.getCedula());
            statement.setString(2, persona.getNombre());
            statement.execute();
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1064:
                    throw new MyExpetion("Error en sintax en SQL");
                default:
                    throw new MyExpetion(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new MyExpetion("Error actualizar Persona", e);
        }
    }

    public List<Persona> listar() throws MyExpetion {
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
            if(lista.isEmpty()){
                throw new MyExpetion("Lista Vacia");
            }
            return lista;
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1064:
                    throw new MyExpetion("Error en sintax en SQL");
                default:
                    throw new MyExpetion(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new MyExpetion("Error Listar Persona", e);
        }
    }

    public Persona buscar(int idb) throws MyExpetion {
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
                return new Persona(id, cedula, nombre, listaTelefonos);
            }
            throw new MyExpetion("Persono no econtrada");
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1064:
                    throw new MyExpetion("Error en sintax en SQL");
                default:
                    throw new MyExpetion(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new MyExpetion("Error buscar Persona por ID", e);
        }
    }

    public Persona buscarCedula(String ced) throws MyExpetion {
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
                return new Persona(id, cedula, nombre, listaTelefonos);
            }
            throw new MyExpetion("Persono no econtrada");
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1064:
                    throw new MyExpetion("Error en sintax en SQL");
                default:
                    throw new MyExpetion(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new MyExpetion("Error buscar Persona por Cedula", e);
        }
    }

}
