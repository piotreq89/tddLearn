package com.packtpublishing.tdd.ch03tictactoe;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by piotrek on 2018-01-04.
 */
public class FooTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void whenDoFooThenThrowRuntimeException(){
        Foo foo = new Foo();
        exception.expect(RuntimeException.class);
        foo.doFoo();

    }

}
