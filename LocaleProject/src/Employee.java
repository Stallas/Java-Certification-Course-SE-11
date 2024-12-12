public class Employee {
    private String name;
    private String dept;
    private String title;

    // Constructor
    public Employee(String name, String dept, String title) {
        System.out.println("Constructing Employee");
        this.name = name;
        this.dept = dept;
        this.title = title;
    }

    //override toString
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", title='" + title + '\'' +
                '}';
    }


}
