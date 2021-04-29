package edu.gcit.lab9;

import androidx.test.filters.SmallTest;

import org.hamcrest.number.BigDecimalCloseTo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
    private Calculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }
    @Test
    public void AddTwoNumber(){
        double Result = mCalculator.Add(2d,2d);
        assertThat(Result,is(equalTo(4d)));
    }
    @Test
    public void AddTwoNumberNegative(){
        double Result = mCalculator.Add(-2d,2d);
        assertThat(Result,is(equalTo(0d)));
    }
    @Test
    public void AddTwoNumberFloat(){
        double Result = mCalculator.Add(2.22f,2.22d);
        assertThat(Result,is(closeTo(4.44,0.001)));
    }

    @Test
    public void SubtractTwoNumber(){
        double Result = mCalculator.Sub(2d,4d);
        assertThat(Result,is(equalTo(-2d)));
    }
    @Test
    public void SubtractTwoNumberNegative(){
        double Result = mCalculator.Sub(-2d,2d);
        assertThat(Result,is(equalTo(-4d)));
    }
    @Test
    public void SubtractTwoNumberFloat(){
        double Result = mCalculator.Sub(1.11f,2.22d);
        assertThat(Result,is(closeTo(-1.11,0.001)));
    }
    @Test
    public void MultiplyTwoNumber(){
        double Result = mCalculator.Mul(2d,4d);
        assertThat(Result,is(equalTo(8d)));
    }
    @Test
    public void MultiplyTwoNumberNegative(){
        double Result = mCalculator.Mul(-2d,2d);
        assertThat(Result,is(equalTo(-4d)));
    }
    @Test
    public void MultiplyTwoNumberFloat(){
        double Result = mCalculator.Mul(1.11f,2.22d);
        assertThat(Result,is(closeTo(2.4642,0.001)));
    }
    @Test
    public void MultiplyNumberWithZero(){
        double result = mCalculator.Mul(23,0);
        assertThat(result,is(equalTo(0.0)));
    }
    @Test
    public void DivideTwoNumber(){
        double Result = mCalculator.Div(2d,4d);
        assertThat(Result,is(equalTo(0.5d)));
    }
    @Test
    public void DivideTwoNumberNegative(){
        double Result = mCalculator.Div(-2d,2d);
        assertThat(Result,is(equalTo(-1d)));
    }
    @Test
    public void DivideTwoNumberFloat(){
        double Result = mCalculator.Div(1.11f,2.22d);
        assertThat(Result,is(closeTo(0.5,0.001)));
    }
    @Test
    public void DivideNumberByZero(){
        double Result = mCalculator.Div(23d,0d);
        assertThat(Result, is(equalTo(Double.POSITIVE_INFINITY)));
    }

}
