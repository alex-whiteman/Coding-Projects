Creator: Alex Whiteman

This program emulates a simple communication protocol between two or more
computers within the same network.

IMPORANT NOTES:

The "MyNetworkNodeID," which corresponds to the netword node
value in the ITC file, must be hardcoded for each machine 
running the server class. I.E. computer 1 must be hardcoded as node 1. 
2 as node 2. etc.

To run this program, all computers must be running the Node class. Only one
computer needs to run the MessageClient class.

The MessageClient class is only responsible for sending the initial message, 	
the node class running on all computers will deal with the packet from then 
forward. The node class will determine whether to keep the message or send the
message forward, depending on the best case scenario for that packet.
