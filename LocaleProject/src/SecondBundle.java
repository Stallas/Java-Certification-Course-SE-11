import java.util.ListResourceBundle;

public class SecondBundle extends ListResourceBundle {
    // This is Second Bundle which contains keys/values other than strings
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"default","Yes"},
                {"synonyms", new String[]{"Yea","Yes","Sure","Of course"}},
                {"jane",new Employee("Jane","HR","Manager")},
                {"age", 40}
        };
    }
}
