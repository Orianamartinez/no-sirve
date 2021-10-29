/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author orian
 */
@Service
public class ServicioCliente {
    
    @Autowired
    private RepositorioCategoria metodosCrud;
    
    public List<Categoria> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Categoria> getCategoria (int categoriaId){
        return metodosCrud.getCategoria(categoriaId);
    }
    
    public Categoria seve (Categoria categoria){
        if(categoria.getId()==null){
            return metodosCrud.save(categoria);
        }else{
            Optional<Categoria> e=metodosCrud.getCategoria(categoria.getId());
            if(e.isEmpty()){
                return metodosCrud.save(categoria);
            }else{
                return categoria;
            }
        }
                
    }
    
    public Categoria upDate(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria> g=metodosCrud.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }                  
                return metodosCrud.save(g.get());
            }                        
        }
        return categoria;
        
    }
    
    public boolean deleteCategoria(int categoriaId){
        Boolean aBoolean = getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return  aBoolean;
    }
    
}
