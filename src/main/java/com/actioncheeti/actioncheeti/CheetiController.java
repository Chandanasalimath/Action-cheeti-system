package com.actioncheeti.actioncheeti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cheeti")
public class CheetiController {

    @Autowired
    private CheetiRepository cheetiRepository;

    // Create cheeti
    @PostMapping
    public Cheeti createCheeti(@RequestBody Cheeti cheeti) {
        return cheetiRepository.save(cheeti);
    }

    // Get all cheetis
    @GetMapping
    public List<Cheeti> getAllCheeti() {
        return cheetiRepository.findAll();
    }
}