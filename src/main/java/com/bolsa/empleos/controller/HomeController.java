package com.bolsa.empleos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/listado")
     public String mostarListado(Model model){
     List<String> lista = new LinkedList<String>();
     lista.add("Ingeniero en Sistemas");
     lista.add("Ingeniero Civil");
     lista.add("Ingeniero en Mecatronica");
     lista.add("Licenciado en Administracion");
     lista.add("Licenciado en Biologia");
     lista.add("Licenciado en Gastronomia");

     model.addAttribute("empleos",lista);
     return  "listado";
     }

    @GetMapping("/")
     public  String mostrarHome(Model model){
        /*
        model.addAttribute("mensaje","Bienvenidos a empleos App");
        model.addAttribute("fecha", new Date());
        */
     String nombre = "Auxiliar de contabilidad";
     Date fechaPub = new Date();
     double salario = 9000.0;
     boolean vigente = true;

     model.addAttribute("nombre",nombre);
     model.addAttribute("fecha",fechaPub);
     model.addAttribute("salario",salario);
     model.addAttribute("vigente",vigente);

          return  "home";
     }
}
