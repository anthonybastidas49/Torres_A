/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.services;

import ec.edu.espe.model.Padre;
import java.util.List;

/**
 *
 * @author Anthony
 */
public class Pruebas {
    public static void main(String[] args) {
        PadreService servicio=new PadreService();
        HijoService servicioH=new HijoService();
        List<Padre> padre=servicio.buscarTodo();
        System.out.println(servicioH.buscarPK(1).getNombre());
        System.out.println(padre.size()+"aaa");
    }
}
