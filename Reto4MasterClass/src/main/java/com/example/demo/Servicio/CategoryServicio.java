/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Category;
import com.example.demo.Repositorio.CategoriaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class CategoryServicio {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    
     public List<Category> getAll() {
        return categoriaRepositorio.getAll();
    }

    public Optional<Category> getCategory(int categoryId) {
        return categoriaRepositorio.getCategory(categoryId);
    }

    public Category save(Category categoria) {
        if (categoria.getId() == null) {
            return categoriaRepositorio.save(categoria);
        } else {
            Optional<Category> categoria1 = categoriaRepositorio.getCategory(categoria.getId());
            if (categoria1.isEmpty()) {
                return categoriaRepositorio.save(categoria);
            } else {
                return categoria;
            }
        }
    }
    
    public Category update(Category categoria){
        if(categoria.getId()!=null){
            Optional<Category>g= categoriaRepositorio.getCategory(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return categoriaRepositorio.save(g.get());
            }
        }
        return categoria;
    }
    
    
    public boolean deleteCategory (int id){
        Boolean d = getCategory(id).map(category -> {
            categoriaRepositorio.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
    
   
    
  
}
