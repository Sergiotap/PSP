import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.HashMap;
//No funciona
public class HashChecker {

    public static void main(String[] args) throws Exception {
        HashMap<String, String> hashValues = new HashMap<>();
        hashValues.put("archivo1.txt", "563f0ec969c9e8359d3a8b6170b1e30c");
        hashValues.put("archivo2.txt", "c36b32e719df9f42b2d0c078840be45d");
        hashValues.put("archivo3.txt", "5c5b5ef57bb7c1d62f365f7bf62325da");

        for (String key : hashValues.keySet()) {
            String hash = calculateMD5(key); // función para calcular el md5sum del archivo
            if (hash.equals(hashValues.get(key))) {
                System.out.println("El hash del archivo " + key + " ha sido bien calculado.");
            } else {
                System.out.println("El hash del archivo " + key + " no coincide.");
            }
        }
    }

    // función para calcular el md5sum del archivo
    public static String calculateMD5(String fileName) throws Exception {
        FileInputStream fis = new FileInputStream(fileName);
        byte[] buffer = new byte[1024];
        MessageDigest md = MessageDigest.getInstance("MD5");
        int numRead;
        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                md.update(buffer, 0, numRead);
            }
        } while (numRead != -1);
        fis.close();
        byte[] md5Bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            sb.append(String.format("%02x", md5Byte & 0xff));
        }
        return sb.toString();
    }
}
