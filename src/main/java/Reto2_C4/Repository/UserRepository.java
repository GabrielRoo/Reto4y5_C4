/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_C4.Repository;

import Reto2_C4.Interfaces.UserInterface;
import Reto2_C4.Model.Order;
import Reto2_C4.Repository.OrderRepository;
import Reto2_C4.Model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gabrielroa
 */
@Repository
public class UserRepository {
    @Autowired
    private UserInterface userCrudRepository;
    
    public List <User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }
    
    public Optional <User> getUser(int id){
        return userCrudRepository.findById(id);
    }
    
    public User save (User user){
        return userCrudRepository.save(user);
    }
    
    public void update(User user) {
        userCrudRepository.save(user);
    }
    
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    
    public boolean emailExists (String email){
    Optional <User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }
    
    public Optional <User> authenticateUser (String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    public List <User> birthDayList (String monthBirthDay){
        return userCrudRepository.findByMonthBirthtDay(monthBirthDay);
    }
   
}
