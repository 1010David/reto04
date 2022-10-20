/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.AudienceInterface;
import com.example.demo.Interface.ClientInterface;
import com.example.demo.Modelo.Audience;
import com.example.demo.Modelo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author USUARIO
 */
@Repository

public class AudienceRepositorio {
    @Autowired
    private AudienceInterface audienceCrudRepository;
    
      public List<Audience> getAll(){
        return (List<Audience>) audienceCrudRepository.findAll();
    }
    
    public Optional<Audience> getClient(int id){
        return audienceCrudRepository.findById(id);
    }

    public Audience save(Audience audience){
        return audienceCrudRepository.save(audience);
    }
     
    public void delete(Audience audience){
        audienceCrudRepository.delete(audience);
    }


    public Optional<Audience> getAudience() {
        return null;
    }
}
