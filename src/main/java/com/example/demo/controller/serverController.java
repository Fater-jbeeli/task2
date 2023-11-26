package com.example.demo.controller;

import com.example.demo.model.Server;
import com.example.demo.repo.ServerRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/server")
public class serverController {

    private final ServerRepo serverRepo;


    @PostMapping("/create")
    public ResponseEntity<String> create( @RequestBody  Server server ){
        serverRepo.save(server);

        return ResponseEntity.ok("saved");
    }

    @GetMapping("/get")
    public ResponseEntity<List<Server>> get(){
        List<Server> servers = serverRepo.findAll();
        return ResponseEntity.ok(servers);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> delete(@PathVariable("id") Long id){
         serverRepo.deleteById(id);
        return ResponseEntity.ok("deleted");

    }
    @PutMapping("/update")
    public  ResponseEntity<String> update(@RequestBody Server server){
        serverRepo.save(server);
        return ResponseEntity.ok("updated");

    }










}
