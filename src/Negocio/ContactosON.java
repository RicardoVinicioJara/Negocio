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
                    if (telefonoDAO.ingresar(t)) {
                        return true;
                    } else {
                        throw new Exception("Error al ingresar Telefono");
                    }
                }
            }
        } else {
            throw new Exception("Error al ingresar Persona");
        }
        return true;
    }

}
