package com.packtpublishing.tdd.ch03tictactoe;

/**
 * Created by piotrek on 2018-01-04.
 */
public class TicTacToe {

    private static final int MINIMAL_VALUE = 1;
    private static final int MAXIMUN_VALUE = 3;
    public static final int SIZE_BOARD = 3;
    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    private char lastPlayer = '0';

    public String play(int a, int b){
        checkPointPosition(a, b);
        addPointToBox(a, b);
        lastPlayer = nextPlayer();

        if (isWin()){
            return "Wygrał " + lastPlayer;
        }else if(isDraw()){
            return "Wynik remisowy";
        }else{
            return "Brak zwycięscy";
        }
    }

    private boolean isDraw(){
        for (int x = 0 ; x < SIZE_BOARD; x++){
            for (int y = 0; y < SIZE_BOARD; y++){
                if(board[x][y] == '\0'){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin() {
        for (int index = 0; index < SIZE_BOARD; index++){
            if (board[0][index] == lastPlayer && board[1][index] == lastPlayer && board[2][index] == lastPlayer){
                return true;
            }else if(board[index][0] == lastPlayer && board[index][1] == lastPlayer && board[index][2] == lastPlayer){
                return true;
            }else if(board[0][0] == lastPlayer && board[1][1] == lastPlayer && board[2][2] == lastPlayer ){
                return true;
            }else if(board[0][2] == lastPlayer && board[1][1] == lastPlayer && board[2][0] == lastPlayer ){
                return true;
            }
        }
        return false;
    }

    private void checkPointPosition(int a, int b) {
        if(pointIsOutsideBoard(a) || pointIsOutsideBoard(b)){
            throw new RuntimeException("Wartosc wykracza poza plansze");
        }
    }
    private boolean pointIsOutsideBoard(int a) {
        return a < MINIMAL_VALUE || a > MAXIMUN_VALUE;
    }

    private void addPointToBox(int a, int b){
        if(board[a -1][b -1] != '\0'){
            throw new RuntimeException("Pole jest juz zajete");
        }else{
            board[a -1][b - 1] = 'X';
        }
    }

    public char nextPlayer(){
        if (lastPlayer == 'X'){
            return '0';
        }
        return 'X';
    }
}
