/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

/**
 *
 * @author maruyamashunsuke
 */
    
public class Main {

    public static void main(String[] args) {

        User user = new User();
        Dealer dealer = new Dealer();

        user.setCard(dealer.deal());
        dealer.setCard(dealer.deal());

        System.out.println("■ ディール時");
        System.out.println("User:" + user.myCards);
        System.out.println("Dealer" + dealer.myCards);
        System.out.println("");

        while (user.checkSum()) {
            user.setCard(dealer.hit());
        }

        while (dealer.checkSum()) {
            dealer.setCard(dealer.hit());
        }

        System.out.println("■ 最終結果");
        System.out.println("Dealer:" + dealer.open());
        System.out.println("手札 :" + dealer.myCards);
        System.out.println("");
        System.out.println("User :" + user.open());
        System.out.println("手札 :" + user.myCards);
        System.out.println("");

        System.out.println("■ 結果発表");

        if (dealer.open() == user.open()) {
            System.out.println("引き分け");
        } else if (dealer.open() > 21 && user.open() > 21) {
            System.out.println("Dealerの勝ち(両者 バスト)");
        } else if (user.open() > 21){
            System.out.println("Dealerの勝ち(User バスト)");            
        } else if (dealer.open() > 21){
            System.out.println("Userの勝ち(Dealer バスト)");
        } else if (dealer.open() == 21) {
            System.out.println("Dealerの勝ち(ブラックジャック)");
        } else if (user.open() == 21) {
            System.out.println("Userの勝ち(ブラックジャック)");
        } else if (dealer.open() > user.open()) {
            System.out.println("Dealerの勝ち");
        } else if (dealer.open() < user.open()) {
            System.out.println("Userの勝ち");
        }
    }
}
