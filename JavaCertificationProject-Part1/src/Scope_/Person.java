package Scope_;
/*
    Section 3 : Working with Java Primitive Data Types and String APIs
    Topic: Identify the Scope of a variable
*/
public class Person {
    static String name = "UNKNOWN";     // Class Variable
    String instanceName = "UNKNOWN";    // Instance Variable
    String age = "25";  // Instance Variable initialized;

    //No Args Constructor
    public Person(){

    }
    //Single Parameter Constructor
    public Person(String age){
        /* Constructors are perfect examples of how a method parameter name
           can have same name as class or instance variable name.
           In this constructor, the person instance age does not get set at all,
           because age not qualified by 'this'. This is a common mistake and may be tested on exam
         */
        age = age;

    }

    // Two-Args Constructor
    public Person(String name,String age){
        /* constructor parameters are named and typed the same as the class variable 'name' and the
        instance variable 'age'. Correctly setting object's age using 'this' qualifier.
        instanceName is an instance variable and has different name from the parameter which will be
        assigned to it, so this not required, but good practice to use it.
        Also, setting static variable name in same assignment statement
         */
        this.age=age;
        this.instanceName=Person.name=name;
    }

    // Simple setter for age where method sets instance variable age to parameter passed.
    public void setAge(String age){
        this.age = age;
    }

    // Simple setter for instanceName
    public void setInstanceName(String instanceName){
        this.instanceName = instanceName;
    }
    /*
      Here, instance and class variable  names have scope within all non-static methods
      of the enclosing class, no qualifier required.
      Qualifiers do help readability though
     */
    public String toString(){
        return instanceName + " is " + age + " years old (" + getAgeGroupClassification() + ", "+
                getDecade(Integer.parseInt(this.age)) + ")";
    }

    // This method tests local variable declaration in if/else blocks
    public String getAgeGroupClassification() {

        String ageClassification = "GenY";
        //This local variable age 'shadows' instance variable age
        int age = Integer.parseInt(this.age);

        if (age >= 95) ageClassification = "the Greatest generation";
        else if (age >= 75) ageClassification = "the silent generation";
        else if (age >= 55) ageClassification = "baby boomer";
        else if (age >= 40) ageClassification = "GenX";
        else if (age >= 20) {
            ageClassification = "Millenial";
            String ageType = "";
            if(age >= 21){
                ageType = "Voting ";
            }
            ageClassification = ageType + ageClassification;
        }
      //  ageClassification = ageType + ageClassification; //agetype out of scope
            return ageClassification;
    }

    public String getDecade(int age) {
        String decadeString = "";
        int decadeNumber = age/10;

        int j = 0;
        // for(int i=0,j=0 ; leads to compile error as j already declared so right to left assignment
        for(int i=j=0;i<(decadeNumber + 1); i++,j++){

            String decade = "Decade "+ (age/10);
            if(i == decadeNumber){
                decadeString = decade;
            }
        }
        int modYear = age % 10;
        decadeString += ", Year " + modYear;
        return decadeString;
    }


}
