package Vencislav;

public class Board {
    private static String[][] board = {
            //      PLACE                      BUY PRICE        OWNER         ID
            {
                    "Start",
            },
            {
                    "Okolchitsa st.",
            },
            {
                    "Bratq Miladinovi st.",
            },
            {
                    "bul. July",
            },
            {
                    "Income Tax",
            },
            {
                    "Vratsa Train Station",
            },
            {
                    "Kaleto",
            },
            {
                    "Chance",
            },
            {
                    "Dunav Bridge",
            },
            {
                    "Dunav Bridge2",
            },
            {
                    "Jail Visiting",
            },
            {
                    "Sumi",
            },
            {
                    "Electricity Tax",
            },
            {
                "Rock club",
            },
            {
                "Mali",
            },
            {
                "Mezdra Train Station",
            },
            {
                "Ledenika Street",
            },
            {
                "Ledenika Factury",
            },
            {
              "G-town",
            },
            {
                "Free Parking"
            },
            {
              "Chaika",
            },
            {
                "Chance",
            },
            {
                "The Skuta",
            },
            {
                "Hotel Hemus",
            },
            {
                "Train Station Vidin",
            },
            {
                "Hizhata",
            },
            {
                "Kaulfand",
            },
            {
              "Billa",
            },
            {
                "Water Tax",
            },
            {
                "Butka za duneri",
            },
            {
                "GO TO JAIL",
            },
            {
                "Duner Butka",
            },
            {
                "Banicharnica",
            },
            {
                "Non Stop Shop",
            },
            {
                "Train Station Ruska Biala",
            },
            {
                "Chance",
            },
            {
                "Hotel Rodina",
            },
            {
                "SUPER TAX",
            },
            {
                "Chinese shop",
            }

    };
    public static void writeMas(){
        for (int i = 0; i < board.length; i++) {

            System.out.println(board[i][0]);

        }
    }
}
