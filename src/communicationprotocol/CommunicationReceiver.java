/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communicationprotocol;

/**
 *
 * @author User
 */
public class CommunicationReceiver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        receiver.receive();
    }
    
}
