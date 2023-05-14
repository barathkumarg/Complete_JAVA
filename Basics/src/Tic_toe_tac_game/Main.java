package Tic_toe_tac_game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        System.out.println("Game Starts");
        game.display();
        while (true) {

            //player turn
            while(true){
                System.out.println("Enter the choice: ");
                int num = input.nextInt();

                if(num>=9 || game.boardcheck(num))
                    continue;
                game.player(num);
                break;
            }
            game.display();

            if(game.playerWinCheck()) {
                System.out.println("Tic_toe_tac_game.Player Wins");
                break;
            }


            if(game.isdraw()){
                System.out.println("Draw");
                break;
            }


            System.out.println("Computer playing....");

            //computer turn
            game.computer();
            game.display();

            if(game.computerWinCheck()) {
                System.out.println("Computer Wins");
                break;
            }
            if(game.isdraw()){
                System.out.println("Draw");
                break;
            }




        }
    }
}