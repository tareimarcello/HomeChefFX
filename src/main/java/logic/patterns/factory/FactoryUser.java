package logic.patterns.factory;

import logic.model.Chef;
import logic.model.Customer;


public  class FactoryUser {

    public Chef createChef(long id,String name, String surname, String email, String password, String restaurant,String bestDish,String city){
        Chef ch =  new Chef(id, name, surname, email, password, restaurant, bestDish);
        ch.setCitta(city);
        return ch;
    }

    public Customer createCustomer(long id,String name, String surname, String email, String password,boolean bookNot){
        return new Customer(id, name, surname, email, password, bookNot);
    }

}
