import java.util.Date;

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