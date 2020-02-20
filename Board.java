package Vencislav;

import javafx.geometry.HPos;

import java.util.Scanner;

public class Board {
    private Scanner input = new Scanner(System.in);
    public String[][] board = {
            //      PLACE                      BUY PRICE        OWNER         ID
            {
                    "Start","","",""
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
                    "Income Tax","","",""
            },
            {
                    "Vratsa Train Station", "200", "", "train"
            },
            {
                    "Kaleto", "100", "", "2"
            },
            {
                    "Chance","","",""
            },
            {
                    "Dunav Bridge", "110", "", "2"
            },
            {
                    "Dunav Bridge2", "120", "", "2"
            },
            {
                    "Jail Visiting","","",""
            },
            {
                    "Sumi", "150", "", "3"
            },
            {
                    "Electricity Tax",
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
                    "Free Parking","","",""
            },
            {
                    "Chaika", "180", "", "5"
            },
            {
                    "Chance","","",""
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
                    "Water Tax","","",""
            },
            {
                    "Butka za duneri", "310", "", "7"
            },
            {
                    "GO TO JAIL","","",""
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
                    "Chance","","",""
            },
            {
                    "Hotel Rodina", "360", "", "8"
            },
            {
                    "SUPER TAX","","",""
            },
            {
                    "Chinese shop", "370", "", "8"
            }

    };

    public String boardPos(int pos, String owner) {
        System.out.println(board[pos][0]);

        if (board[pos][2] != ""&&!isBankBelonging(pos)) {
            System.out.print(" Owner:" + owner);
        }

        return board[pos][0];
    }
    public String placeOwner(int pos){
            return board[pos][2];
    }

    public boolean setOwner(int i, String owner) {
        if (!isBankBelonging(i) && board[i][2] == "") {
            if (isBuying()) {
                board[i][2] = owner;
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean isBankBelonging(int i) {
        if (i == 0 || i == 4 || i == 7 || i == 10 || i == 12 || i == 19 || i == 21 || i == 28 || i == 30 || i == 35 || i == 37)
            return true;
        else return false;
    }

    public boolean isBuying() {
        System.out.println("Would you like to buy this property? Write \'y\' fore yes or \'n\' for no");
        char choiceToBuy = input.next().charAt(0);
//        if (choiceToBuy != 'n' && choiceToBuy != 'y') {
//            System.out.println("Wrong input.");
//            return isBuying();
//        }
        if (choiceToBuy == 'n') {
            return false;
        }
        return true;
    }
}
//TODO There is bug with bankBelongings or isBuying repair them
