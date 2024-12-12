package Inheritance;
/*
    Section 9: Reusing Implementations Through Inheritance
    Topic:3. Create and use subclasses and superclasses
    Sub-Topic : Out of ordinary. Static field and inheritance.
 */
// Employee class with type, name attributes
class Employee{
    private String type;
    private String name;
    Employee(String name, String type){
        this.name = name;
        this.type = type;
    }
}
/*
    Company has two static fields, and two methods which increment the fields,
    Leaving them public for demonstration purposes.
 */
class Company{
    public static int branchCount;
    public static int employeeCount;

    public void addEmployee(Employee e){
        employeeCount++;
    }
    public void addBranch(Branch b){
        branchCount++;
    }
    // adding these
    static{
        System.out.println("Company Static Initializer");
        branchCount = 10;
    }
}
// Company is a subclass of Branch
class Branch extends Company{
    private String branchName = "unspecified";
    // adding these
//    public static int branchCount;
//    public static int employeeCount;
    public int branchCount;
    public int employeeCount;

    Branch(String branchName){
        this.branchName = branchName;
    }
    // adding these
//    static {
//        System.out.println("Branch Static Initializer");
//        employeeCount = 200;
//    }
    {
        System.out.println("Branch Static Initializer");
        employeeCount = 200;
    }

    public void addEmployee(Employee e){
        employeeCount++;
    }
}
public class OnBoardBranch {
    public static void main(String[] args) {

        // Create some object
        Branch b = new Branch("AxisBranch");
        Employee e1 = new Employee("Carol","President");
        Employee e2 = new Employee("Ralph","Vice President");
        Company main = new Company();

        // Execute the methods that should effect the static fields
        main.addBranch(b);
        b.addEmployee(e1);
        b.addEmployee(e2);

        // The static variable defined on company accessed here
        System.out.println("Number of Branches = "+ Company.branchCount);//1
        System.out.println("Number of Employees = "+ Company.employeeCount);//2

        // What does it mean to access the static variables from Branch ?
//        initially there is no static init and branchcount and employeeCount
        System.out.println("Call from Branch: number of Branches = "+ b.branchCount);//1 Branch.branchCount
        System.out.println("Call from Branch: number of Employees = "+ b.employeeCount);//2 Branch.employeeCount

    }
}
