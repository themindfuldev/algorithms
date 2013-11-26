package algorithms.string;

//input  : 'a--aa-ba--cbb--c---c-'
//output : '+++++-ba--c++--+++++-'

public class CharacterBridge {
    public String makeCharacterBridge(String input) {
        // consider input is valid
        // any combination of hyphens and letters, at least one char        
        StringBuilder output = new StringBuilder();
        char currentBridgeChar = 0;        
        int inputLength = input.length();
        int currentBridgeStartPosition = -1;
        int currentBridgeStopPosition = -1;
        int bridgeLength = 0;
        
        for (int i=0; i < inputLength; i++) {
            char currentChar = input.charAt(i);   
            output.append(currentChar);
        
            // If bridge is not being built
            if (currentBridgeChar == 0) {
                if (currentChar != '-') {
                    // Potentially a bridge is starting
                    currentBridgeChar = currentChar;
                    currentBridgeStartPosition = i;
                    bridgeLength++;
                }
                continue;
            }
            
            // If bridge is being built
            if (currentChar == currentBridgeChar) {
                bridgeLength++;
                currentBridgeStopPosition = i;
                continue;            
            }
            
            if (currentChar == '-' && i < inputLength - 1) {
                continue;            
            }
            
            // Otherwise, the bridge is over
            if (bridgeLength == 1) {
            	currentBridgeChar = currentChar;
            	currentBridgeStartPosition = i;
                continue;
            }
            
            // Do the bridge
            if (currentBridgeStopPosition != -1) {
	            for (int j=currentBridgeStartPosition; j <= currentBridgeStopPosition; j++) {
	                output.setCharAt(j, '+'); 
	            }
	            bridgeLength = 1;
	            currentBridgeChar = currentChar;
	            currentBridgeStartPosition = i;
	            currentBridgeStopPosition = -1;
            }
        }
        
        return output.toString();
        
    }
}