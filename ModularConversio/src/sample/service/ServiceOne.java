package sample.service;

import sample.core.UtilityClass;
import sample.entity.EntityOne;

public class ServiceOne {
    // has a private attribute of EntityOne
    private EntityOne e = new EntityOne("ServiceOne has an entity ");

    // Constructor which uses UtilityClass
    public ServiceOne(String s){
        UtilityClass.doSomethingStatic("ServiceOne instantiated with "+ s);
    }
}
