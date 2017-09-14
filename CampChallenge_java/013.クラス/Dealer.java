/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author maruyamashunsuke
 */

public class Dealer extends Human {

    ArrayList<Integer> cards = new ArrayList<>();

    //　初期処理
    Dealer() {

        //　cardsに52個(1～13×4)の要素を格納
        for (int i = 0; i < 4; i++) {

            cards.add(1);      // 1
            cards.add(2);      // 2
            cards.add(3);      // 3
            cards.add(4);      // 4
            cards.add(5);      // 5
            cards.add(6);      // 6
            cards.add(7);      // 7
            cards.add(8);      // 8
            cards.add(9);      // 9
            cards.add(10);     // 10
            cards.add(10);     // 11
            cards.add(10);     // 12
            cards.add(10);     // 13
        }
    }

    //　ディール：カードを2枚配る
    public ArrayList<Integer> deal() {

        ArrayList<Integer> dealCard = new ArrayList<>();

        Random rand = new Random();

        for (int i = 0; i < 2; i++) {

            Integer index = rand.nextInt(cards.size());

            dealCard.add(cards.get(index));
        }

        return dealCard;
    }

    //　ヒット：カードを1枚配る
    public ArrayList<Integer> hit() {

        ArrayList<Integer> hitCard = new ArrayList<>();

        Random rand = new Random();

        Integer index = rand.nextInt(cards.size());

        hitCard.add(cards.get(index));

        return hitCard;
    }

    //　カード情報を格納
    @Override
    public void setCard(ArrayList<Integer> set) {

        for (int i = 0; i < set.size(); i++) {
            myCards.add(set.get(i));
        }
    }

    //　ヒットするかしないか判断
    @Override
    public boolean checkSum() {

        if (open() < 18) {
            return true;
        } else {
            return false;
        }
    }

    //　オープン
    @Override
    public int open() {

        int sum = 0;

        for (int i = 0; i < myCards.size(); i++) {
            sum += myCards.get(i);
        }

        return sum;
    }
}
