package com.example.estore.EstoreApp.controller;

import com.example.estore.EstoreApp.entities.Configuration;
import com.example.estore.EstoreApp.service.serviceImpl.ConfigurationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/configuration")
@RequiredArgsConstructor
public class ConfigurationController {

    private final ConfigurationServiceImpl configurationServiceImpl;


    @GetMapping
    @CrossOrigin(origins ="http://localhost:4200")
    public List<Configuration> getConfigurations() {
        return configurationServiceImpl.getConfigurations();
    }

    @PostMapping("/add")
    @CrossOrigin(origins ="http://localhost:4200")
    public ResponseEntity<Configuration> addConfiguration(@RequestBody Configuration configuration) {
        return ResponseEntity.ok(configurationServiceImpl.addConfiguration(configuration)) ;
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @DeleteMapping("/delete/{configurationId}")
    public void deleteConfiguration(@PathVariable("configurationId") Long configurationId) {
        configurationServiceImpl.deleteConfiguration(configurationId);
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/update/{configurationId}")
    public ResponseEntity<Configuration> updateConfiguration(@PathVariable("configurationId") Long configurationId, @RequestBody Configuration configuration) {
        return ResponseEntity.ok(configurationServiceImpl.updateConfiguration(configurationId, configuration)) ;
    }
}
