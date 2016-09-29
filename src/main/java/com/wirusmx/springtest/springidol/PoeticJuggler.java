package com.wirusmx.springtest.springidol;

public class PoeticJuggler extends Juggler {
    private Poem poem;

    public PoeticJuggler(int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    public PoeticJuggler(Poem poem) {
        super();
        this.poem = poem;
    }

    @Override
    public void perform() throws PerformanceException {
        super.perform();
        System.out.printf("While reciting ...");
        poem.recite();
    }
}
