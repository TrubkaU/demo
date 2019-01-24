package com.example.agerasimenko.demoproject.domen;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaClassTest {

    @Test
    public void getHowAreYou() {

        assertEquals(JavaClass.HOW_ARE_YOU, new JavaClass().getHowAreYou());
    }
}