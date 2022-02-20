import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


//this class takes the ITC file and parses it into separate NetworkNodes, so that 
//connected nodes are aware of who they are connected to.

public class ITCParse {
   
    private String ITCScript;
    public Map<Integer, NetworkNode> networkNodes = new HashMap<Integer, NetworkNode>();

    public ITCParse(String script) {
        ITCScript = script;
    }

    public void initializeNodes() {
       
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(ITCScript);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String strLine;
        try {
            while ((strLine = reader.readLine()) != null) {
                
                if (strLine.equals("")==false){
                    String[] splitStr = strLine.split("\\s+");
                    NetworkNode networkNode = new NetworkNode();
                    networkNode.id = Integer.parseInt(splitStr[0]);
                    networkNode.hostName = splitStr[1];
                    networkNode.port = Integer.parseInt(splitStr[2]);
                    networkNode.FirstConnectedNode = (byte) Integer.parseInt(splitStr[3]);
                    networkNode.SecondConnectedNode = (byte) Integer.parseInt(splitStr[4]);
                    networkNode.MaximumTransmissionUnit = (short) Integer.parseInt(splitStr[5]);
                    networkNodes.put(Integer.parseInt(splitStr[0]),networkNode);
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
