package Vencislav;

import javafx.geometry.HPos;

import java.util.Scanner;

public class Board {
    private Scanner input = new Scanner(System.in);
    public String[][] board = {
            //      PLACE                      BUY PRICE        OWNER         ID
            {
                    "Start", "", "Bank", ""
            },
            {
                    "Okolchitsa st.", "60", "", "1"
            },
            {
                    "Bratq Miladinovi st.", "80", "", "1"
            },
            {
                    "bul. July", "90", "", "1"
            },
            {
                    "Income Tax", "", "Bank", ""
            },
            {
                    "Vratsa Train Station", "200", "", "train"
            },
            {
                    "Kaleto", "100", "", "2"
            },
            {
                    "Chance", "", "Bank", ""
            },
            {
                    "Dunav Bridge", "110", "", "2"
            },
            {
                    "Dunav Bridge2", "120", "", "2"
            },
            {
                    "Jail Visiting", "", "Bank", ""
            },
            {
                    "Sumi", "150", "", "3"
            },
            {
                    "Electricity Tax", "", "Bank", ""
            },
            {
                    "Rock club", "160", "", "3"
            },
            {
                    "Mali", "170", "", "3"
            },
            {
                    "Mezdra Train Station", "200", "", "train"
            },
            {
                    "Ledenika Street", "160", "", "4"
            },
            {
                    "Ledenika Factury", "170", "", "4"
            },
            {
                    "G-town", "180", "", "4"
            },
            {
                    "Free Parking", "", "Bank", ""
            },
            {
                    "Chaika", "180", "", "5"
            },
            {
                    "Chance", "", "Bank", ""
            },
            {
                    "The Skuta", "190", "", "5"
            },
            {
                    "Hotel Hemus", "200", "", "5"
            },
            {
                    "Train Station Vidin", "200", "", "train"
            },
            {
                    "Hizhata", "210", "", "6"
            },
            {
                    "Kaulfand", "220", "", "6"
            },
            {
                    "Billa", "230", "", "6"
            },
            {
                    "Water Tax", "", "Bank", ""
            },
            {
                    "Butka za duneri", "310", "", "7"
            },
            {
                    "GO TO JAIL", "", "", ""
            },
            {
                    "Duner Butka", "320", "", "7"
            },
            {
                    "Banicharnica", "330", "", "7"
            },
            {
                    "Non Stop Shop", "350", "", "8"
            },
            {
                    "Train Station Ruska Biala", "200", "", "train"
            },
            {
                    "Chance", "", "Bank", ""
            },
            {
                    "Hotel Rodina", "360", "", "8"
            },
            {
                    "SUPER TAX", "", "Bank", ""
            },
            {
                    "Chinese shop", "370", "", "8"
            }

    };
    private boolean isBuying;
    private boolean isBankBelonging;

    public String quickCheck() {
        String check = "no";
        for (int i = 0; i < board.length; i++) {

            if (board[i][0].equals("Duner Butka"))
                check = board[i][2];
        }
        return check;
    }

    public String boardPos(int pos, String owner) {
        System.out.println(board[pos][0]);

        if (!board[pos][2].equals("") && !isBankBelonging(pos)) {
            System.out.print(" Owner:" + owner);
        }

        return board[pos][0];
    }
    public String boardPos(int i){
        return board[i][0];
    }

    public String placeOwner(int pos) {
        return board[pos][2];
    }

    public boolean isFree(int i) {
        return !board[i][2].equals("");
    }

    public void setOwner(int i, String owner) {
        board[i][2] = owner;
    }

    public boolean isBankBelonging(int i) {
        if (i == 0 || i == 4 || i == 7 || i == 10 || i == 12 || i == 19 || i == 21 || i == 28 || i == 30 || i == 35 || i == 37)
            return true;
        else return false;
    }

    public boolean isBuying() {
        System.out.println("Would you like to buy this property? Write \'y\' fore yes or \'n\' for no");
        char choiceToBuy = input.next().charAt(0);
        if (choiceToBuy != 'n' && choiceToBuy != 'y') {
            System.out.println("Wrong input.");
            return isBuying();
        } else if (choiceToBuy == 'n') {
            return false;
        } else if (choiceToBuy == 'y') {
            System.out.println("You bought this property!");
            return true;
        }
        return false;
    }


}
