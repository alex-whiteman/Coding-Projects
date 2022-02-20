import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.net.*;

/* This class is responsible for listening for incoming packets and determining
if the server should hold the packet for itself or send the packet forward to another node.

THE NETWORK NODE ID ON LINE 18 MUST BE MANUALLY CONFIGURED FOR EACH NODE FOR THE PROGRAM TO 
WORK CORRECTLY!!!
 */

public class Node {

	private DatagramSocket datagramSocket;
	private DatagramPacket inbound;
	public static Map<Integer, NetworkNode> networkNodes = new HashMap<Integer, NetworkNode>();
	private static int myNetworkNodeId = 1;
	private static int hop1;
	private static int hop2;

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the ITC filepath:");
		String filePath = input.nextLine();
		input.close();

		if (args.length != 0) {
			myNetworkNodeId = Integer.parseInt(args[0]);
			filePath = args[1];
		}

		ITCParse parser = new ITCParse(filePath);
		parser.initializeNodes();
		networkNodes = parser.networkNodes;
		parser.networkNodes = null;

		if (networkNodes.containsKey(myNetworkNodeId)) {
			NetworkNode currentNode = networkNodes.get(myNetworkNodeId);
			Node server = new Node(currentNode.port, currentNode.MaximumTransmissionUnit);
			System.out.println(currentNode.hostName);
			hop1 = currentNode.FirstConnectedNode;
			hop2 = currentNode.SecondConnectedNode;
			server.waitForPacket();
		}
	}

	public Node(int port, int MaximumTransmissionUnit) throws IOException {

		datagramSocket = new DatagramSocket(port);
		byte[] buffer = new byte[MaximumTransmissionUnit];
		inbound = new DatagramPacket(buffer, buffer.length);
	}

	public void waitForPacket() throws UnknownHostException {

		byte[] packetBytes = new byte[10000];
		System.out.println("Waiting for packet...\n");
		// recieve inbound packet
		try {
			datagramSocket.receive(inbound);
			System.out.println("Processing...\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// parse packet and determine if recipient or not
		packetBytes = inbound.getData();
		String data = new String(packetBytes);
		String[] dataParsed = data.split("#");
		// if this machine is recipient then display message
		if (Integer.parseInt(dataParsed[1]) == myNetworkNodeId) {
			System.out.println("Message Recieved!\n");
			System.out.println(dataParsed[3]);

		// if hop one is recipient send to hop1
		} else if (Integer.parseInt(dataParsed[1]) == hop1) {
			if (networkNodes.containsKey(hop1)) {
				NetworkNode currentNode = networkNodes.get(hop1);
				byte[] buffer = new byte[100];
				try {
					DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
							InetAddress.getByName(currentNode.hostName), 10224);
					byte[] dataByte = data.getBytes();
					GarbleSend.garble(dataByte);
					packet.setData(dataByte);
					datagramSocket.send(packet);
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
		else if(Integer.parseInt(dataParsed[1])==hop2){
			if (networkNodes.containsKey(hop2)) {
				NetworkNode currentNode = networkNodes.get(hop2);
				byte[] buffer = new byte[100];
				try {
					DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
							InetAddress.getByName(currentNode.hostName), 10224);
					byte[] dataByte = data.getBytes();
					GarbleSend.garble(dataByte);
					packet.setData(dataByte);
					datagramSocket.send(packet);
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
		//last resort measure. Sent to hop1 and hope that Node can further transport message.
		else {
			NetworkNode currentNode = networkNodes.get(hop1);
				byte[] buffer = new byte[100];
				try {
					DatagramPacket packet = new DatagramPacket(buffer, buffer.length,
							InetAddress.getByName(currentNode.hostName), 10224);
					byte[] dataByte = data.getBytes();
					GarbleSend.garble(dataByte);
					packet.setData(dataByte);
					datagramSocket.send(packet);
				} catch (IOException e) {
					e.printStackTrace();
				}			
		}
	}
}
