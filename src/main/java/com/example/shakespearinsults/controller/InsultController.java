package com.example.shakespearinsults.controller;

import com.example.shakespearinsults.model.Insult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.shakespearinsults.service.InsultService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shakespear/insults")
public class InsultController {

    @Autowired
    private InsultService insultService;

    @GetMapping("/")
    public ResponseEntity<List<Insult>> getAll(){
        List<Insult> insults = insultService.getAll();

        if (insults.isEmpty()) {
            return ResponseEntity.status(204).body(insults);
        } else {
            return ResponseEntity.status(200).body(insults);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Insult> create(@RequestBody Insult insult) {

        if (insult.getInsult() == null) {
            return ResponseEntity.status(400).body(insult);
        }

        insultService.create(insult);
        return ResponseEntity.status(201).body(insult);
    }

    @GetMapping("/{index}")
    public ResponseEntity<Insult> getInsultById(@PathVariable int index) {
        List<Insult> insults = insultService.getAll();


        if (index < 0 || index >= insults.size()) {
            return ResponseEntity.notFound().build();
        } else {
            Insult insult = insults.get(index);
            return ResponseEntity.status(200).body(insult);
        }
    }

    @DeleteMapping("/{index}")
    public ResponseEntity delete(@PathVariable int index){
        List<Insult> insults = insultService.getAll();

        if (index < 0 || index >= insults.size()) {
            return ResponseEntity.status(404).build();
        } else {
            insultService.delete(index);
            return ResponseEntity.status(200).build();
        }
    }

    @PatchMapping("/{index}")
    public ResponseEntity<Insult> update(@PathVariable int index, @RequestBody Insult insult) {
        List<Insult> insults = insultService.getAll();

        if (index < 0 || index >= insults.size()) {
            return ResponseEntity.status(404).build();
        } else {
            insultService.update(index, insult);
            return ResponseEntity.status(200).build();
        }

    }


}
