package LocalVarriableTypeInferences;

import java.util.ArrayList;

public class VarTest {
    public static void main(String[] args) {
       // AClassWithAVeryLongName aClassWithAVeryLongName= new AClassWithAVeryLongName();
        var aClassWithAVeryLongName = new AClassWithAVeryLongName();
        aClassWithAVeryLongName.setName("Testing");

        System.out.println(aClassWithAVeryLongName);

        /*
        Adding some other var declarations: i is inferred to be an int,since it's assigned a literal int.
         */
        var i = 1;

        // An array can be assigned to an LVTI variable
        var aVarArray = new int[3];

        // Valid to assign a method return value to an LVTI variable
        var methodVal = aClassWithAVeryLongName.getName();

        //OK to assign a null object to LVTI variable but not literal null
        Object nullObj = null;
        var var = nullObj;

        var j = 1.0f/2;
        short s= 1;
        var k = +s;
        var list = new ArrayList<String>();
        var myArray = new String[5];
        // Invalid declarations

        //cannot use var declarations in a compound statement
        //var j = 0,k=0;
        //var j,k = 0;

        //cannot declare a var variable without also initialising it
        //var tempObj;

        //cannot assign null to var variable, type cannot be inferred
        //var newObj = null;

        //cannot use array initializer in var declaration/initialization
        //var myArray = {"A","B"};

        //cannot have an array of var
        //var[] newArray = new int[2];

    }
}
