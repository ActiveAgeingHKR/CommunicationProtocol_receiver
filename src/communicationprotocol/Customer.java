/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communicationprotocol;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Customer extends Person implements Serializable{
    int pulse;

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }
}
