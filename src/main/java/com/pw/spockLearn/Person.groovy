package com.pw.spockLearn

import groovy.transform.Canonical

/**
 * Created by piotrek on 2018-01-14.
 */

@Canonical
public class Person {

    String firstName
    String lastName
    Integer age

    boolean isAdult(){
        age >= 18
    }
}
