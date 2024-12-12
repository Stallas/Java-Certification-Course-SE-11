package LocalVarriableTypeInferences;
// Local Variable Type Inference
public class AClassWithAVeryLongName {

    String name;
    public AClassWithAVeryLongName(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AClassWithAVeryLongName{" +
                "name='" + name + '\'' +
                '}';
    }
}
