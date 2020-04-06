/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Persona;
import Entidades.Telefono;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinic
 */
public class NewClass {

    public static void main(String[] args) {
        List<Telefono> list = new ArrayList<>();
        Telefono t = new Telefono(14, "0990550718", "A", 14);
        list.add(t);
        PersonaDAO p = new PersonaDAO();
        Persona per = new Persona(14, "0105452114", "Ricardo", list);
        p.ingresar(per );
        list = per.getListaTelefonos();
        TelefonoDAO tel = new TelefonoDAO();
        for (Telefono list1 : list) {
            tel.ingresar(list1);
        }
    }
}
