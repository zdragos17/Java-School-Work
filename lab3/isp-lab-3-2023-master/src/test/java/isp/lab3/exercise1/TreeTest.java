package isp.lab3.exercise1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeTest
{
    @Test
    public void TreeTest()
    {
        Tree tree = new Tree();
        assertEquals(17, tree.grow(2));
        assertEquals(17, tree.grow(-1));
        assertEquals(17, tree.grow(0));
    }

    @Test
    public void ToStringTest()
    {
        Tree tree = new Tree();
        assertEquals("Tree{height=15}", tree.toString());
        tree.grow(2);
        assertEquals("Tree{height=17}", tree.toString());
    }
}
