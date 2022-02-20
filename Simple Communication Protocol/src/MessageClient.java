import java.net.*;
import java.io.*;
import java.util.Scanner;

/* the purpose of this class is to send the initial message, which
can be sent to any node in the network. This simple message is representative
of any data that can be transmitted between two nodes. 
 */
public class MessageClient{

	private Scanner input;
   	private DatagramSocket datagramSocket;
	private InetAddress receiverAddress;
	private DatagramPacket packet; 
	private String recieveNode;
	private	String sendNode;
	private	String ttl;
	private	String message;

	 public static void main(String[] args) throws IOException{
		
       MessageClient client =  new MessageClient();
       client.sendMessage();
              
	}
	
    public MessageClient() throws IOException{

        datagramSocket = new DatagramSocket();
		byte[] buffer = new byte[100];
		input = new Scanner(System.in);
		//gets IP address of node that message needs sent to.
		System.out.println("Please enter the IP address of the next hop recipient you wish to "
		+"\n"+"initialize the message transmission with: (ex. 10.0.0.0)");
		receiverAddress = InetAddress.getByName(input.nextLine());
		packet  = new DatagramPacket(buffer, buffer.length, receiverAddress, 10224);
    }

    void sendMessage() {
		//gets nodeID of sender
		System.out.println("Please enter the nodeID of this machine:");
		input = new Scanner(System.in);
		if (input.hasNextLine()){
			sendNode = input.nextLine();
		}		
		//gets IP address of node that message needs sent to.
		System.out.println("Please enter the nodeID of the recipient:");
		input = new Scanner(System.in);
		recieveNode = input.nextLine();
		//set ttl to 10
		ttl = "10";
		//gets message
		System.out.println("Please enter the message you would like to send:");
		input = new Scanner(System.in);
		message =  input.nextLine();
		input.close();
		String data = sendNode + "#" + recieveNode + "#" + ttl + "#" + message;
		byte[] dataByte = data.getBytes();
		//potential for packet loss at below line due to garbler class.
		GarbleSend.garble(dataByte);
    	packet.setData(dataByte);
    	System.out.println("Sending message...\n");
    	
    	try {
			datagramSocket.send(packet);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
