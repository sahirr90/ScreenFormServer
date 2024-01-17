package com.screenForm.screen.domain.screenForm.controllers;

import com.screenForm.screen.domain.screenForm.models.ScreenForm;
import com.screenForm.screen.domain.screenForm.services.ScreenFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/screen-request")
@CrossOrigin("*")
public class ScreenFormController {
    private ScreenFormService screenFormService;

    @Autowired
    public ScreenFormController(ScreenFormService screenFormService) {
        this.screenFormService = screenFormService;
    }

    @GetMapping
    public ResponseEntity<List<ScreenForm>> getAll(){
        List<ScreenForm> employees = screenFormService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ScreenForm> create(@RequestBody ScreenForm screenForm){
        screenForm = screenFormService.create(screenForm);
        return new ResponseEntity<>(screenForm, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ScreenForm> getById(@PathVariable("id") Long id){
        ScreenForm screenForm = screenFormService.getById(id);
        return new ResponseEntity<>(screenForm, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<ScreenForm> getByEmail(@RequestParam String email){
        ScreenForm screenForm = screenFormService.getByEmail(email);
        return new ResponseEntity<>(screenForm, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ScreenForm> update(@PathVariable("id") Long id, @RequestBody ScreenForm screenFormDetail){
        screenFormDetail = screenFormService.update(id, screenFormDetail);
        return new ResponseEntity<>(screenFormDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        screenFormService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
