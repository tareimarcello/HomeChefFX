package logic.patterns.factory;

import logic.model.Chef;
import logic.model.Customer;


public  class FactoryUser {

    public Chef createChef(long id,String name, String surname, String restaurant,String bestDish,String city){
        return new Chef(id, name, surname, restaurant, bestDish,city);
    }

    public Customer createCustomer(long id,String name, String surname,boolean bookNot){
        return new Customer(id, name, surname,bookNot);
    }

}
