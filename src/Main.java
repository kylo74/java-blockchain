import java.util.Date;
import java.security.MessageDigest;

public class stringUtil {
    //Applies sha256 to a string and returns the result
    public static  String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //Applies sha 256 to our input
            byte[] hash = digest.digest(input.getBytes("Utf-8"));
            StringBuffer hexString = new StringBuffer(); //This will contain a hexadecimal hash

            for (int i = 0; i < hash.length; i++){
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

public class Block {

    public String hash;
    public String previousHash;
    private String data; //The data will be a simple message
    private long timeStamp; //number of milliseconds since 1/1/1970

    //This creates blocks
    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
    }
}