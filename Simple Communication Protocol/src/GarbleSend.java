import java.util.Random ;

public class GarbleSend{

    public GarbleSend() {
    }

    public static byte[] garble (byte[] data) {
        // Garble/drop the packet
        Random random = new Random();
        int C = random.nextInt(101); // packet corruption fraction (between 0 and 100)
        
        Random rand = new Random(); // random generator
        if (!(rand.nextInt(101) < C)) { // corrupt the packet
                int randomLocationToGarble = 0; // holds the byte location of the packet to be garbled
            // Corrupt the packet
            if (data.length > 0) { // Determine the size of the packet
                randomLocationToGarble = rand.nextInt(data.length);
                data[randomLocationToGarble] = (byte)(~((int)data[randomLocationToGarble]));
            System.out.println("The byte located at index: "+ randomLocationToGarble +" has been corrupted!");
            }
        }
        return data;
    }
}