package Encapsulation;

public class QuizASuperClass {
    public void printPublicData(String data){
        System.out.println(data);
    }
     void printPackageData(String data){
        System.out.println(data);
    }
    protected void printProtectedData(String data){
        System.out.println(data);
    }
    private void printPrivateData(String data){
        System.out.println(data);
    }
}
