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
import Utils.MyExpetion;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class ContactosON {

    private PersonaDAO personaDAO;
    private TelefonoDAO telefonoDAO;

    public ContactosON() throws Exception {
        personaDAO = new PersonaDAO();
        telefonoDAO = new TelefonoDAO();
    }

    public boolean guardadoContacto(Persona persona) throws MyExpetion {
        if (validarCedula(persona.getCedula())) {
            try {
                personaDAO.ingresar(persona);
                int maxId = personaDAO.maxId();
                if (maxId != 0) {
                    List<Telefono> listaTelefonos = persona.getListaTelefonos();
                    for (Telefono t : listaTelefonos) {
                        t.setPersona_id(maxId);
                        telefonoDAO.ingresar(t);
                    }
                }
            } catch (MyExpetion e) {
                throw new MyExpetion(e.getMessage());
            } catch (Exception e) {
                throw new MyExpetion(e.getMessage());
            }
        } else {
            throw new MyExpetion("Cedula Incorrecta");
        }

        return true;
    }

    public List<Persona> listarContactos() throws MyExpetion {
        try {
            return personaDAO.listar();
        } catch (MyExpetion e) {
            throw new MyExpetion(e.getMessage());
        } catch (Exception e) {
            throw new MyExpetion(e.getMessage());
        }
    }

    public List<Telefono> listarTelefonos(int id) throws MyExpetion {
        try {
            return telefonoDAO.listar(id);
        } catch (MyExpetion e) {
            throw new MyExpetion(e.getMessage());
        } catch (Exception e) {
            throw new MyExpetion(e.getMessage());
        }
    }

    public Persona buscarPersonaCedula(String cedula) throws MyExpetion {
        try {
            return personaDAO.buscarCedula(cedula);
        } catch (MyExpetion e) {
            throw new MyExpetion(e.getMessage());
        } catch (Exception e) {
            throw new MyExpetion(e.getMessage());
        }
    }

    public void eliminarPersona(Persona p) throws MyExpetion {
        try {
            List<Telefono> lista = p.getListaTelefonos();
            for (Telefono t : lista) {
                eliminarTelefono(t.getId());
            }
            personaDAO.eliminar(p.getId());
        } catch (MyExpetion e) {
            throw new MyExpetion(e.getMessage());
        } catch (Exception e) {
            throw new MyExpetion(e.getMessage());
        }

    }

    public void eliminarTelefono(int id) throws MyExpetion {
        try {
            telefonoDAO.eliminar(id);
        } catch (MyExpetion e) {
            throw new MyExpetion(e.getMessage());
        } catch (Exception e) {
            throw new MyExpetion(e.getMessage());
        }
    }

    public void actualizarContacto(Persona persona) throws MyExpetion {
        try {
            personaDAO.actualizar(persona);
            List<Telefono> listPersonas = persona.getListaTelefonos();
            for (Telefono list : listPersonas) {
                telefonoDAO.actualizar(list);
            }
        } catch (MyExpetion e) {
            throw new MyExpetion(e.getMessage());
        } catch (Exception e) {
            throw new MyExpetion(e.getMessage());
        }
    }

    public boolean validarCedula(String ced) {
        boolean verdadera = false;
        int num = 0;
        int ope = 0;
        int suma = 0;
        for (int cont = 0; cont < ced.length(); cont++) {
            num = Integer.valueOf(ced.substring(cont, cont + 1));
            if (cont == ced.length() - 1) {
                break;
            }
            if (cont % 2 != 0 && cont > 0) {
                suma = suma + num;
            } else {
                ope = num * 2;
                if (ope > 9) {
                    ope = ope - 9;
                }
                suma = suma + ope;
            }
        }
        if (suma != 0) {
            suma = suma % 10;
            if (suma == 0) {
                if (suma == num) {
                    verdadera = true;
                }
            } else {
                ope = 10 - suma;
                if (ope == num) {
                    verdadera = true;
                }
            }
        } else {
            verdadera = false;
        }
        return verdadera;
    }

}
