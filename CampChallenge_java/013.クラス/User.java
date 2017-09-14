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

public class User extends Human {

    @Override
    public void setCard(ArrayList<Integer> set) {

        for (int i = 0; i < set.size(); i++) {
            myCards.add(set.get(i));
        }
    }

    @Override
    public boolean checkSum() {

        if (open() < 18) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int open() {

        int sum = 0;

        for (int i = 0; i < myCards.size(); i++) {
            sum += myCards.get(i);
        }

        return sum;
    }

}
