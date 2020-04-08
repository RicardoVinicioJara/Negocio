/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class TelefonoDAO {

    Conexion con = new Conexion();
    Connection coneccion;

    public TelefonoDAO() throws Exception {
        try {
            coneccion = con.getConnection();
        } catch (Exception e) {
            System.err.println(e.getCause());
            throw new Exception("Error de conexion");

        }
    }

    public void ingresar(Telefono telefono) throws MyExpetion {
        try {
            String Query = "INSERT INTO telefono(NUMERO, TIPO, PERSONA_ID)values(?,?,?) ";
            PreparedStatement statement = coneccion.prepareStatement(Query);

            statement.setString(1, telefono.getNumero());
            statement.setString(2, telefono.getTipo());
            statement.setInt(3, telefono.getPersona_id());
            statement.execute();

        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1062:
                    throw new MyExpetion("Duplicacion el codigo primario");
                case 1064:
                    throw new MyExpetion("Error en sintax en SQL");
                default:
                    throw new MyExpetion(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new MyExpetion("Erro ingreso telefono", e);
        }
    }

    public void eliminar(int id) throws MyExpetion {
        try {
            String Query = "DELETE from telefono WHERE ID = '" + id + "'";
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
            throw new MyExpetion("Error eliminar telefono", e);
        }
    }

    public void actualizar(Telefono telefono) throws MyExpetion {
        try {
            String Query = "UPDATE telefono SET NUMERO = ?,TIPO = ?, PERSONA_ID  = ? WHERE ID = " + telefono.getId();
            PreparedStatement statement = coneccion.prepareStatement(Query);

            statement.setString(1, telefono.getNumero());
            statement.setString(2, telefono.getTipo());
            statement.setInt(3, telefono.getPersona_id());
            statement.execute();
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1064:
                    throw new MyExpetion("Error en sintax en SQL");
                default:
                    throw new MyExpetion(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new MyExpetion("Error actualizar telefono", e);
        }
    }

    public List<Telefono> listar(int id) throws MyExpetion {
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
            if(lista.isEmpty()){
                throw new MyExpetion("Lista Vacia de telefonos");
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
            throw new MyExpetion("Error Listar telefonos", e);
        }
    }

    public Telefono buscar(int idb) throws MyExpetion {
        String sql = "select * from telefono where id = '" + idb + "'";
        try {
            Statement se1 = coneccion.createStatement();
            ResultSet seter1 = se1.executeQuery(sql);
            while (seter1.next()) {
                int id1 = seter1.getInt(1);
                String numero = seter1.getString(2);
                String tipo = seter1.getString(3);
                return new Telefono(id1, numero, tipo, idb);
            }
            throw new MyExpetion("Telefono no econtrado por id");
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1064:
                    throw new MyExpetion("Error en sintax en SQL");
                default:
                    throw new MyExpetion(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new MyExpetion("Error Listar telefono por id", e);
        }
    }

    public Telefono buscarNumero(String num) throws MyExpetion {
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
                return new Telefono(id1, numero, tipo, idp);
            }
            throw new MyExpetion("Telefono no econtrado por id");
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1064:
                    throw new MyExpetion("Error en sintax en SQL");
                default:
                    throw new MyExpetion(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new MyExpetion("Error Listar telefono por id", e);
        }
    }
}