package StringBuilder_;
/*
    Topic: Manipulate Data With StringBuilder
    Sub-Topic:2. Append Methods
 */
public class SBAppendInsert {
    public static void main(String[] args) {
        /*
        There are many flavours of append:
         */

        StringBuilder sb = new StringBuilder(100);
        sb.append("Hello ")
                .append(new char[] {'W','o','r','l','d'})
                .append(',')
                .append((Object) "My")
                .append("NewNumber ",3,9)
                .append(" is ")
                .appendCodePoint(65)
                .append(" float with the value of : ")
                .append(204.50f);
        System.out.println("sb = "+ sb);
        System.out.println("sb.length() = "+sb.length());
        System.out.println("sb.capacity() = "+sb.capacity());

        /*
        Some of many insert methods
         */
        StringBuilder sb2 = new StringBuilder(100);
        sb2.insert(0,"Hello, is a float with the value of ")
                .insert(6, new char[]{'W','o','r','l','d'})
                .insert(13,(Object) "My ")
                .insert(16, "NewNumber ",3,10)
                .insert(sb2.length(),204.5f);

        System.out.println("sb2 = "+ sb2);
        System.out.println("sb2.length() = "+sb2.length());
        System.out.println("sb2.capacity() = "+sb2.capacity());
    }
}
