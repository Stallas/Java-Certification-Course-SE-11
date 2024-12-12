package Scope_;

public class TestPerson {
    public static void main(String[] args) {

        Person joe = new Person("JOE","55");
        Person deb = new Person("DEB","85");

        Person ann = new Person();
        ann.setAge("21");
        ann.setInstanceName("ANN");

        System.out.println(joe);
        System.out.println(deb);
        System.out.println(ann);
    }
}
