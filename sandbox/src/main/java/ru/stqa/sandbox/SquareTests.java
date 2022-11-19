package ru.stqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {
    @Test
    public void testArea() {
        Square s = new Square(5);
        assert s.squareArea() == 25;
        Assert.assertEquals(s.squareArea(), 25);
    }
}