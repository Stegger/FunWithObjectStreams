/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithobjectstreams;

import java.io.Serializable;

/**
 *
 * @author pgn
 */
public class Address implements Serializable {

    
    private String street;
    private String country;

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCountry() {
        return this.country;
    }

    @Override
    public String toString() {
        return new StringBuffer(" Street : ")
                .append(this.street)
                .append(" Country : ")
                .append(this.country).toString();
    }

}
