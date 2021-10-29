/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author orian
 */
@Repository
public class RepositorioCliente {
        @Autowired
    private InterfaceCliente crud;
    
    public List<Client> getAll(){
        return (List<Client>) crud.findAll();
    }
    
    public Optional<Client> getClient(int id){
        return crud.findById(id);
    }
    
    public Client save(Client client){
        return crud.save(client);
    }
    
    public void delete(Client client){
        crud.delete(client);
    }
}
