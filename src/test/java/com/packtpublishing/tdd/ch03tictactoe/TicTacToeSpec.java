package com.packtpublishing.tdd.ch03tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

/**
 * Created by piotrek on 2018-01-04.
 */
public class TicTacToeSpec {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TicTacToe ticTacToe;

    @Before
    public final void before(){
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException(){

        exception.expect(RuntimeException.class);
        ticTacToe.play(5,2);
    }

    @Test
    public void whenTOutsideBoardThenRuntimeException(){
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,5);
    }

    @Test
    public void whenOccupiedThenRuntimeException(){
        ticTacToe.play(2,1);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,1);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX(){
        Assert.assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastTurnWasXWhenextPlayerThen0(){
        ticTacToe.play(1,1);
        Assert.assertEquals('0', ticTacToe.nextPlayer());
    }

    @Test
    public void whenPlayThenNoWinner(){
        String actual = ticTacToe.play(1,1);
        Assert.assertEquals("Brak zwycięscy", actual);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner(){
        ticTacToe.play(1,1); //X
        ticTacToe.play(1,2); //0
        ticTacToe.play(2,1); //X
        ticTacToe.play(2,2); //0
        String actual = ticTacToe.play(3,1); //X
        Assert.assertEquals("Wygrał X", actual);
    }

//    @Test
//    public void whenPlayAndWholeVerticalLineThenWinner(){
//        ticTacToe.play(2,1); //X
//        ticTacToe.play(1,1); //0
//        ticTacToe.play(3,1); //X
//        ticTacToe.play(1,2); //0
//        ticTacToe.play(2,2); //X
//        String actual = ticTacToe.play(1, 3);//0
//        Assert.assertEquals("Wygrał 0", actual);
//    }

    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner(){
        ticTacToe.play(1,1); //X
        ticTacToe.play(1,2); //0
        ticTacToe.play(2,2); //X
        ticTacToe.play(1,3); //0
        String actual = ticTacToe.play(3, 3);//X
        Assert.assertEquals("Wygrał X", actual);

    }

    @Test
    public void whenPlayAndBottomTopDiagonalLineThenWinner(){
        ticTacToe.play(1,3); //X
        ticTacToe.play(1,1); //0
        ticTacToe.play(2,2); //X
        ticTacToe.play(1,2); //0
        String actual = ticTacToe.play(3, 1);//X
        Assert.assertEquals("Wygrał X", actual);
    }

    @Test
    public void whenAllBoxesAreFiledThenDraw(){
        ticTacToe.play(1,1);
        ticTacToe.play(1,2);
        ticTacToe.play(1,3);
        ticTacToe.play(2,1);
        ticTacToe.play(2,3);
        ticTacToe.play(2,2);
        ticTacToe.play(3,1);
        ticTacToe.play(3,3);
        String actual = ticTacToe.play(3, 2);
        Assert.assertEquals("Wynik remisowy", actual);
    }
}
