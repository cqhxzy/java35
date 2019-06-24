package test2;

public class Test3 {
    public static void main(String[] args) {

        try{Object o=null;
        System.out.println(o);}
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
