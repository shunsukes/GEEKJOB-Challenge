/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import java.util.ArrayList;

/**
 *
 * @author maruyamashunsuke
 */

public abstract class Human {

    public abstract void setCard(ArrayList<Integer> set);

    public abstract boolean checkSum();

    public abstract int open();

    ArrayList<Integer> myCards = new ArrayList<Integer>();
}
