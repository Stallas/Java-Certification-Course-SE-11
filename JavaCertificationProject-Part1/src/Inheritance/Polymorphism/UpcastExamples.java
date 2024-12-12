package Inheritance.Polymorphism;
/*
    Section 9: Reusing Implementations Through Inheritance
    Topic: 12. Utilize polymorphism to cast and call methods
    Sub-Topic: upcasting works well incase of attributes but not for object parameter.
 */
// Tree is the base class
class Tree{
    String type = "unknown";
    String getTreeString(){
        return "Tree";
    }
}

// Deciduous is a subclass of Tree
class DeciduousTree extends Tree{
    String type = "deciduous";
    String getTreeString(){
        return "Leafy Tree";
    }
}
// Fruit is a subclass of Tree
class FruitTree extends Tree{
    String type = "fruit";
    String getTreeString(){
        return "Fruit Tree";
    }
}

public class UpcastExamples {
    public static void main(String[] args) {
        UpcastExamples uex = new UpcastExamples();

        // Create 2 specific trees
        DeciduousTree mapleTree = new DeciduousTree();
        FruitTree appleTree = new FruitTree();
        System.out.println("mapleTree type : "+mapleTree.type);

        // We upcast them to parent class.Note for passing as object we cant upcast line1,2,3
        Tree genericTree = (Tree) mapleTree;
        System.out.println("Tree type : "+ genericTree.type);
        System.out.println("Tree getTreeString : "+ genericTree.getTreeString());//line1

        // Let's upcast to use the generic Tree's type
        System.out.println("Tree type : "+((Tree)mapleTree).type);

        // Upcasting to pass object as a parameter
        uex.printTreeType(appleTree);//line2
        uex.printTreeType((Tree) appleTree);//line3
    }

    public void printTreeType(Tree tree){
        System.out.println("Tree type : "+ tree.getTreeString());
    }
}
