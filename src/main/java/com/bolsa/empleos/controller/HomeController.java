package com.bolsa.empleos.controller;

import com.bolsa.empleos.model.Vacante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@Controller
public class HomeController {

    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
     List<Vacante> lista = getVacantes();
     model.addAttribute("vacantes",lista);
     return "tabla";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model){
     Vacante vacante = new Vacante();
     vacante.setNombre("Ingeniero de software");
     vacante.setDescripcion("Se solicita desarrollador java spring");
     vacante.setFecha(new Date());
     vacante.setSalario(10000.0);
     model.addAttribute("vacante",vacante);
     return "detalle";

    }

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

     private List<Vacante> getVacantes(){

     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
     List<Vacante> lista = new LinkedList<Vacante>();
     try{
      Vacante vacante1 = new Vacante();
      vacante1.setId(1);
      vacante1.setNombre("Ingeniero Civil");
      vacante1.setDescripcion("Solicitamos Ingeniero civil para el diseño de planos de un edificio");
      vacante1.setFecha(sdf.parse("02-01-2025"));
      vacante1.setSalario(20000.0);
      vacante1.setDestacado(1);

      Vacante vacante2 = new Vacante();
      vacante2.setId(2);
      vacante2.setNombre("Contador Publico");
      vacante2.setDescripcion("Solicitamos Contador con 5 años de experiencia titulado");
      vacante2.setFecha(sdf.parse("03-01-2025"));
      vacante2.setSalario(15000.0);
      vacante2.setDestacado(0);

      Vacante vacante3 = new Vacante();
      vacante3.setId(3);
      vacante3.setNombre("Ingeniero Electrico");
      vacante3.setDescripcion("Solicitamos Ingeniero Electrico para el mantenimiento de instalacion electrica");
      vacante3.setFecha(sdf.parse("04-01-2025"));
      vacante3.setSalario(16000.0);
      vacante3.setDestacado(0);

      Vacante vacante4 = new Vacante();
      vacante4.setId(4);
      vacante4.setNombre("Diseñador Grafico");
      vacante4.setDescripcion("Solicitamos UX para el diseño de el maquetado de nuestros sitios web");
      vacante4.setFecha(sdf.parse("05-01-2025"));
      vacante4.setSalario(17000.0);
      vacante4.setDestacado(1);

      lista.add(vacante1);
      lista.add(vacante2);
      lista.add(vacante3);
      lista.add(vacante4);


     }catch (ParseException e){
      System.out.println("Error" + e.getMessage());
     }
     return lista;
     }

}
