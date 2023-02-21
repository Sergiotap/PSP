package repasoExamen.codificacion;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HashCheck {
    public static void main(String[] args) {
        HashMap <String, String> mapa = new HashMap<>();
        mapa.put("cadena1", "241cf92ffed56d15e107993b201962fd");
        mapa.put("cadena2", "invalid_hash");
        for (String clave : mapa.keySet()) {
            String valor = mapa.get(clave);
            String valorCalculado = calcularMD5(clave);
            if(valorCalculado.equalsIgnoreCase(valor)){
                System.out.println("El valor cifrado es correcto");
            }
            else{
                System.out.println("El valor cifrado no es correcto");
            }
        }
    }
    public static String calcularMD5(String clave){
        ProcessBuilder pb = new ProcessBuilder("md5sum", "-");
        pb.redirectInput(ProcessBuilder.Redirect.PIPE);
        pb.redirectOutput(ProcessBuilder.Redirect.PIPE);
        try {
            Process proceso = pb.start();
            proceso.getOutputStream().write(clave.getBytes());
            proceso.getOutputStream().close();

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(proceso.getInputStream()));
            String result = reader.readLine();
            if(result == null){
                return null;
            }
            System.out.println(result);
            return result.split(" ")[0];
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
    
}