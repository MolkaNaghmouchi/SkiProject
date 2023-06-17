package com.example.stationski.controllers;

import com.example.stationski.entities.*;
import com.example.stationski.services.ISkieurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/skieur")
public class SkieurController {
    ISkieurService skieurService;

    @PutMapping("/assignSkieurToPiste/{numSkieur}/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable("numSkieur")Long numSkieur,
                                        @PathVariable("numPiste")Long numPiste) {
        Skieur skieur = skieurService.assignSkieurToPiste(numSkieur,numPiste);
        return skieur;
    }


    @PostMapping("/addSkieurAndAssignToCourse/{numCours}")
    public Skieur addSkieurAndAssignToCourse(@RequestBody Skieur skieur,
                                      @PathVariable("numCours")Long numCours) {
        Skieur s = skieurService.addSkieurAndAssignToCourse(skieur,numCours);
        return s;
    }



    @GetMapping("/retrieveSkieursByTypeAbonnement/{typeAbonnement}")
    public List<Skieur> retrieveSkieursByTypeAbonnement(@PathVariable("typeAbonnement") TypeAbonnement typeAbonnement) {
        List<Skieur> listSkieurs = skieurService.retrieveSkieursByTypeAbonnement(typeAbonnement);
        return listSkieurs;
    }

    @GetMapping("/nombreSkieursParCouleurPiste")
    public  HashMap<Couleur,Integer> nombreSkieursParCouleurPiste() {
        HashMap<Couleur,Integer> nombreSkieursParCouleurPiste = skieurService.nombreSkieursParCouleurPiste();
        return nombreSkieursParCouleurPiste;
    }


}
