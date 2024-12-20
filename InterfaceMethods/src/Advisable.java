/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 3: Interfaces
Topic:  Private methods
*/
// Here , initially both default methods has same block of code, so replace it with NestedClass
// which contains private static method and it is invoked as NestedClass.getLevelCode. Bit ugly code
// so , we can make use of private method which encapsulates and doesn't expose to the outside world.

// Interface to support academic advisors at universities.
interface Advisable {

    // Set up some enums to facilitate code
    enum GradeLevel {
        FRESHMAN("Math", "History"),
        SOPHOMORE("Math", "Political Science"),
        JUNIOR("CompSci", "DiffEq"),
        SENIOR("ElectroMagnetics", "Statistics");
        String[] courses;

        GradeLevel(String... courses) {
            this.courses = courses;
        }
    }

    enum AcademicLevel {
        FAILING, UNSATISFACTORY, SATISFACTORY, OVERACHIEVING
    }

    // This is the method all implementing classes must override
    void advise(GradeLevel gradeLevel, AcademicLevel[] academicLevel);

    // Default method gets schedule by class level
    default String getRequirements(GradeLevel grade,
                                   AcademicLevel[] academicLevel) {

        String reqs = grade.toString();
        for (int i = 0; i < grade.courses.length; i++) {
            String levelCode = getLevelCode(academicLevel[i]);
            // Build schedule...
            reqs += ": \n\t\t "
                    + grade.courses[i] + " "
                    + (grade.ordinal() + 1) + "000"
                    + levelCode;
        }
        return reqs;
    }

    // Default method to get a single class
    default String getClass(GradeLevel grade, String course, AcademicLevel academicLevel) {

        String levelCode = getLevelCode(academicLevel);
        return course + " " + (grade.ordinal() + 1) + "000"
                + levelCode;
    }
//    class NestedClass{
    private static String getLevelCode(AcademicLevel academicLevel) {
        String levelCode = "";
        switch (academicLevel) {
            case FAILING:
            case UNSATISFACTORY:
                levelCode = "UD";
                break;
            case OVERACHIEVING:
                levelCode = "ADV";
        }
        return levelCode;
    }

}

// Implementing Class
class PrivateExamples implements Advisable {

    public static void main(String[] args) {
        PrivateExamples p = new PrivateExamples();
        // Advise a Sophomore not doing great
        p.advise(GradeLevel.SOPHOMORE, new AcademicLevel[]{
                AcademicLevel.UNSATISFACTORY,
                AcademicLevel.SATISFACTORY});

        // Advise a Freshman who is excelling
        p.advise(GradeLevel.FRESHMAN, new AcademicLevel[]{
                AcademicLevel.OVERACHIEVING,
                AcademicLevel.OVERACHIEVING});

        // Get a single class for freshman math
        System.out.println("\nFreshman underperforming in Math takes " +
                p.getClass(GradeLevel.FRESHMAN, "Math",
                        AcademicLevel.UNSATISFACTORY));

    }

    // Concrete implementation of Advisable's advise method
    public void advise(GradeLevel gradeLevel,
                       AcademicLevel[] academicLevel) {
        System.out.println(getRequirements(gradeLevel, academicLevel));
    }

}