/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.PersonaDAO;
import DAO.TelefonoDAO;
import Entidades.Persona;
import Entidades.Telefono;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class ContactosON {

    private PersonaDAO personaDAO;
    private TelefonoDAO telefonoDAO;

    public ContactosON() {
        personaDAO = new PersonaDAO();
        telefonoDAO = new TelefonoDAO();
    }

    public boolean guardadoContacto(Persona persona) throws Exception {
        if (personaDAO.ingresar(persona)) {
            int maxId = personaDAO.maxId();
            if (maxId != 0) {
                List<Telefono> listaTelefonos = persona.getListaTelefonos();
                for (Telefono t : listaTelefonos) {
                    t.setPersona_id(maxId);
                    if (!telefonoDAO.ingresar(t)) {
                       throw new Exception("Error al ingresar Telefono");
                    }
                }
            }
        } else {
            throw new Exception("Error al ingresar Persona");
        }
        return true;
    }

    public List<Persona> listarContactos() {
        List<Persona> listaPersonas = personaDAO.listar();
        if (!listaPersonas.isEmpty()) {
            return listaPersonas;
        } else {
            return null;
        }
    }
    
     public List<Telefono> listarTelefonos(int id) {
        List<Telefono> listaTelefonos = telefonoDAO.listar(id);
        if (!listaTelefonos.isEmpty()) {
            return listaTelefonos;
        } else {
            return null;
        }
    }

}
