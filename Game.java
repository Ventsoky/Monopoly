package Vencislav;
public class Game{
    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        game.gameSetUp();
        while (true){
            if(game.prison()){
                continue;
            }

            game.playerSetUp();
            if(game.jailBlock()){
                continue;
            }
            game.normalPlace();
            game.chanceOrCommunityChest();
            game.charging();
            game.menu();
            game.playerOut();
            if(game.isGameOver())
                break;
            game.nextPlayer();
        }
    }
}