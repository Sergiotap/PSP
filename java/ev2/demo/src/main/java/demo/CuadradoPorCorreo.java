package demo;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class CuadradoPorCorreo {
    private static final String SERVER = "smtp.educa.madrid.org";
    private static final int PORT = 587;
    private static final String MAILFROM = "sergio.tapia1@educa.madrid.org";
    private static final String SUCCESS = "Correo electrónico enviado exitosamente.";
    private static final String SUBJECT = "Mando cuadrado";
    private static final int NUMCORREOS=20;
    private static final int ancho=10;
    private static final int alto=10;
    //private static final String correo="jorge.duenas@educa.madrid.org";
    private static final String correo="Sergiotapiarodr@gmail.com";


    public static void main(String[] args) {
        /*if (args.length<=1) {
            System.out.println("Debes introducir el alto y el ancho");
        }
        else{
        int alto = Integer.parseInt(args[0]);
        int ancho = Integer.parseInt(args[1]);
        String correo = args[2];*/
        String cuadrado = "";
        cuadrado=dibujarCuadrado(ancho, alto);
        int i=0;
        while (i<NUMCORREOS) {
            mandarMail(cuadrado+"\n Por alguna razón, no me deja compilar, solo ejecutar desde Visual los correos.", correo);
            i++;
        }
    }
    public static String dibujarCuadrado(int ancho, int alto) {
        String cuadrado="";
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                if(i==0||i==alto-1){
                    System.out.print("*");
                    cuadrado+="*";
                }
                else if(j==0||j==ancho-1){
                    System.out.print("*");
                    cuadrado+="*";
                }
                else{
                    System.out.print(" ");
                    cuadrado+=" ";
                }
            }
            System.out.println();
            cuadrado+="\n";
        }
        return cuadrado;
    }
    private static void mandarMail(String cuadrado, String correo) {
        String user = "sergio.tapia1";
        String pass = "JFe4or!E";
        Email email = new SimpleEmail();

        email.setHostName(SERVER);
        email.setSmtpPort(PORT);

        email.setAuthentication(user, pass);
        email.setSSLOnConnect(true);
        try {
            email.setFrom(MAILFROM);
            email.setSubject(SUBJECT);
            email.setMsg(cuadrado);
            email.addTo(correo);
            email.send();
            System.out.println(SUCCESS);
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}