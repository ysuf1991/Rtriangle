package ru.sonic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

/**
 * Created by sonic.
 */
public class RtriangleTest {

    @Test
    public void shouldGetCorrectRtriangle() {
        RtriangleProvider.setRtriangle(new Rtriangle(0, 0, 0, 3, 4, 0));
        IRtriangle rtriangle = RtriangleProvider.getRtriangle();
        checkRtriangle(rtriangle);
    }

    @Test(expected = AssertionError.class)
    public void shouldGetInvalidTriangle() {
        RtriangleProvider.setRtriangle(new Rtriangle(0, 0, 1, 1, 3, 3));
        IRtriangle rtriangle = RtriangleProvider.getRtriangle();
        checkRtriangle(rtriangle);
    }

    @Test(expected = AssertionError.class)
    public void shouldGetInvalidRectangularTriangle() {
        RtriangleProvider.setRtriangle(new Rtriangle(0, 0, 4, 0, 3, 3));
        IRtriangle rtriangle = RtriangleProvider.getRtriangle();
        checkRtriangle(rtriangle);
    }

    public static long vectorMultiple(IRtriangle rtriangle) {
        return  (rtriangle.getApexX2() - rtriangle.getApexX1()) * (rtriangle.getApexY3() - rtriangle.getApexY1())
                    - (rtriangle.getApexX3() - rtriangle.getApexX1()) * (rtriangle.getApexY2() - rtriangle.getApexY1());
    }

    public static void checkRtriangle(IRtriangle rtriangle) {
        long sqrSide1 = (long)Math.pow((rtriangle.getApexX1() - rtriangle.getApexX2()), 2)
                            + (long)Math.pow((rtriangle.getApexY1() - rtriangle.getApexY2()), 2);
        long sqrSide2 = (long)Math.pow((rtriangle.getApexX1() - rtriangle.getApexX3()), 2)
                            + (long)Math.pow((rtriangle.getApexY1() - rtriangle.getApexY3()), 2);
        long sqrSide3 = (long)Math.pow((rtriangle.getApexX3() - rtriangle.getApexX2()), 2)
                            + (long)Math.pow((rtriangle.getApexY3() - rtriangle.getApexY2()), 2);

        assertThat("Points located on the same line", vectorMultiple(rtriangle), not(equalTo(0L)));

        assertTrue("Triangle is not rectangular", ((sqrSide1 + sqrSide2) == sqrSide3) ||
                                                  ((sqrSide1 + sqrSide3) == sqrSide2) ||
                                                  ((sqrSide3 + sqrSide2) == sqrSide1));
    }

}
