package repaso;

public class ej5 {
    public static void main(String[] args) {
        if(args.length<1||args[0].equals("\n")||args[0].equals("")){
            System.out.println("No me has mandado cadenas, inútil");
            System.exit(1);
        }
        else{
            for(int i=0;i<5;i++){
                System.out.println(args[0]);
            }
        }
    }
}
