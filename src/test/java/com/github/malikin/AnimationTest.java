package com.github.malikin;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AnimationTest {

    @Test
    public void testA() {
        var input = "..R....";
        assertEquals(
                "[..X...., ....X.., ......X, .......]",
                Arrays.toString(Animation.animate(input, 2).toArray())
        );
    }

    @Test
    public void testB() {
        var input = "RR..LRL";
        assertEquals(
                "[XX..XXX, .X.XX.., X.....X, .......]",
                Arrays.toString(Animation.animate(input, 3).toArray())
        );
    }

    @Test
    public void testC() {
        var input = "LRLR.LRLR";
        assertEquals(
                "[XXXX.XXXX, X..X.X..X, .X.X.X.X., .X.....X., .........]",
                Arrays.toString(Animation.animate(input, 2).toArray())
        );
    }

    @Test
    public void testD() {
        var input = "RLRLRLRLRL";
        assertEquals(
                "[XXXXXXXXXX, ..........]",
                Arrays.toString(Animation.animate(input, 10).toArray())
        );
    }

    @Test
    public void testE() {
        var input = "...";
        assertEquals(
                "[...]",
                Arrays.toString(Animation.animate(input, 10).toArray())
        );
    }

    @Test
    public void testF() {
        var input = "LRRL.LR.LRR.R.LRRL.";
        assertEquals(
                "[XXXX.XX.XXX.X.XXXX., " +
                        "..XXX..X..XX.X..XX., " +
                        ".X.XX.X.X..XX.XX.XX, " +
                        "X.X.XX...X.XXXXX..X, " +
                        ".X..XXX...X..XX.X.., " +
                        "X..X..XX.X.XX.XX.X., " +
                        "..X....XX..XX..XX.X, " +
                        ".X.....XXXX..X..XX., " +
                        "X.....X..XX...X..XX, " +
                        ".....X..X.XX...X..X, " +
                        "....X..X...XX...X.., " +
                        "...X..X.....XX...X., " +
                        "..X..X.......XX...X, " +
                        ".X..X.........XX..., " +
                        "X..X...........XX.., " +
                        "..X.............XX., " +
                        ".X...............XX, " +
                        "X.................X, " +
                        "...................]",
                Arrays.toString(Animation.animate(input, 1).toArray())
        );
    }
}