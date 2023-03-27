package com.example.clase2.controllers;

import com.example.clase2.entity.Persona;
import com.example.clase2.entity.Shipper;
import com.example.clase2.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ShipperController {

    final ShipperRepository shipperRepository;

    public ShipperController(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    @GetMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("lista", shipperRepository.findAll());
        return "shipper/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo() {
        return "shipper/nuevoForm";
    }

    @PostMapping("/guardar")
    public String guardar(Shipper shipper) {
        shipperRepository.save(shipper);
        System.out.println(shipper.getId());

        return "redirect:/listar";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam("id") int id, Model model) {

        Optional<Shipper> shipperOptional = shipperRepository.findById(id);
        if (shipperOptional.isPresent()) {
            Shipper shipper = shipperOptional.get();
            model.addAttribute("shipper", shipper);
            return "shipper/editarForm";
        } else {
            return "redirect:/listar";
        }
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id) {
        Optional<Shipper> shipperOptional = shipperRepository.findById(id);
        if (shipperOptional.isPresent()) {
            shipperRepository.deleteById(id);
        }
        return "redirect:/listar";

    }


    @GetMapping("/")
    public String index(Model model) {
        Persona persona = new Persona();
        persona.setNombre("Cesar");
        persona.setEdad(20);
        model.addAttribute("persona", persona);

        Persona p2 = new Persona();
        p2.setNombre("Alejandro");

        Persona p3 = new Persona();
        p3.setNombre("Gil");

        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(persona);
        lista.add(p2);
        lista.add(p3);

        model.addAttribute("lista", lista);
        return "principal";
    }

    @GetMapping("/ruta2")
    public String ruta2() {
        return "ruta2";
    }

    @PostMapping("/guardar2")
    public String guardar2(Persona persona) {

        System.out.println("nombre: " + persona.getNombre());
        System.out.println("edad: " + persona.getEdad());
        //System.out.println("ciudad: " + ciudad);

        return "";
    }
}
