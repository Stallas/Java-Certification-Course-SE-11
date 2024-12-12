package sample.entity;

import sample.core.UtilityClass;

public class EntityOne {
    // Constructor calls UtilityClass
    public EntityOne(String s){
        UtilityClass.doSomethingStatic("EntityOne instantiated with "+ s);
    }
}
