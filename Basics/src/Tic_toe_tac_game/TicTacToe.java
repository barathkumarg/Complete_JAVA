package Tic_toe_tac_game;

import java.util.ArrayList;
import java.util.Random;
public class TicTacToe {

    private char[] BOARD = {'_','_','_','_','_','_','_','_','_'};
    private char PLAYER = 'X';
    private char COMPUTER = 'O';

    public void display(){
        for (int i=0;i<BOARD.length;i++){

            if (i==3 || i==6 ){
                System.out.println();
            }
            System.out.print((BOARD[i]) + " ");
        }
        System.out.println();
    }

    public void player(int num){
        BOARD[num] = PLAYER;
    }

    public void computer(){

        int min = 0;
        int max = 8;
        Random random = new Random();

        while (true) {
            int randomNumber = random.nextInt((max - min) + 1) + min;
            if (boardcheck(randomNumber)){
                continue;
            }
            BOARD[randomNumber] = COMPUTER;
            break;
        }
    }



    public boolean playerWinCheck(){
        return (rowcheck(PLAYER) || colcheck(PLAYER) || diacheck(PLAYER));
    }

    public boolean computerWinCheck(){
        return (rowcheck(COMPUTER) || colcheck(COMPUTER) || diacheck(COMPUTER));
    }

    public boolean boardcheck(int num){
        if (BOARD[num]!='_')
            return true;
        return false;
    }

    public boolean rowcheck(char symbol){
        for (int i =0;i<3;i++){
            int rowno = i * 3;
            if (BOARD[rowno] == symbol && BOARD[++rowno] == symbol && BOARD[++rowno] == symbol)
                return true;
        }
        return false;
    }

    public boolean colcheck(char symbol){
        for (int i =0;i<3;i++){

            if (BOARD[(i)] == symbol && BOARD[(i+3)] == symbol && BOARD[(i+6)] == symbol)
                return true;
        }
        return false;

    }

    public boolean diacheck(char symbol){

            if (BOARD[(0)] == symbol && BOARD[(4)] == symbol && BOARD[(8)] == symbol) {
                return true;
            }
            else if (BOARD[(2)] == symbol && BOARD[(4)] == symbol && BOARD[(6)] == symbol) {
                return true;

            }

        return false;

    }

    public boolean isdraw(){
        for (int i=0;i<BOARD.length;i++){
            if (BOARD[i]=='_')
                return false;

        }
        return true;

    }






}
