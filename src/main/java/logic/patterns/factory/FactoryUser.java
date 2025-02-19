package logic.patterns.factory;

import logic.model.Chef;
import logic.model.Customer;
import logic.model.User;


public class FactoryUser {

    public User createChef(long id, String name, String surname, String restaurant, String bestDish, String city){
        return new Chef(id, name, surname, restaurant, bestDish,city);
    }

    public User createCustomer(long id,String name, String surname,boolean bookNot){
        return new Customer(id, name, surname,bookNot);
    }

}
