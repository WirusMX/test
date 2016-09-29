package com.wirusmx.springtest.springidol;

public class Sonnet29 implements Poem {
    private static String[] LINES = {
            "bla bla bla",
            "blabla lala"
    };

    public Sonnet29() {
    }

    @Override
    public void recite() {
        for (String line: LINES){
            System.out.println(line);
        }
    }
}
