package logic.patterns.factory;

import logic.model.Chef;
import logic.model.Customer;
import logic.model.User;

public  class FactoryUser {

    public Chef createChef(long id,String name, String surname, String email, String password, String restaurant,String bestDish){
        return new Chef(id, name, surname, email, password, restaurant, bestDish);
    }

    public Customer createCustomer(long id,String name, String surname, String email, String password,boolean bookNot){
        return new Customer(id, name, surname, email, password, bookNot);
    }

    public User create(long id, String name, String surname, String email, String password, String restaurant, String bestDish){
        return null;
    }
}
