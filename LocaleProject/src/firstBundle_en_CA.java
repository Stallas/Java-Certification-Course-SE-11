import java.util.ListResourceBundle;

public class firstBundle_en_CA extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"yes","Yea"},
                {"no","nah"},
                {"unsure","Not sure"}
        };
    }
}
