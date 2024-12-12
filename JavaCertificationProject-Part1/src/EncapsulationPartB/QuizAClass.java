package EncapsulationPartB;

import Encapsulation.QuizASuperClass;

public class QuizAClass extends QuizASuperClass {
    public static void main(String[] args) {
        new QuizAClass().printProtectedData("Hello World");
        new QuizAClass().printPublicData("Hello World");
    }
}
