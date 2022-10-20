/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Audience;
import com.example.demo.Repositorio.AudienceRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author USUARIO
 */
@Service
public class AudienceServicio {
    @Autowired
    private AudienceRepositorio audienceRepositorio;
    
     public List<Audience> getAll() {
        return audienceRepositorio.getAll();
    }

    public Optional<Audience> getAudience(int audienceId) {
        return audienceRepositorio.getAudience();
    }

    public Audience save(Audience audience) {
        if (audience.getId() == null) {
            return audienceRepositorio.save(audience);
        } else {
            Optional<Audience> audience1 = audienceRepositorio.getAudience();
            if (audience1.isEmpty()) {
                return audienceRepositorio.save(audience);
            } else {
                return audience;
            }
        }
    }
    
    public Audience update(Audience audience){
        if(audience.getId()!=null){
            Optional<Audience>g= audienceRepositorio.getAudience();
            if(!g.isEmpty()){
                if(audience.getDescription()!=null){
                    g.get().setDescription(audience.getDescription());
                }
                if(audience.getName()!=null){
                    g.get().setName(audience.getName());
                }
                return audienceRepositorio.save(g.get());
            }
        }
        return audience;
    }
    
    
    public boolean deleteCategory (int id){
        Boolean d = getAudience(id).map(audience -> {
            audienceRepositorio.delete(audience);
            return true;
        }).orElse(false);
        return d;
    }


    public boolean deleteAudience(int id) {
        return false;
    }
}
