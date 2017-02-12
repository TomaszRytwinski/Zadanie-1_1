package com.capgemini.fibonacciTest;

import org.junit.Test;
import org.junit.Assert;
import com.capgemini.fibonacci.Fibonacci;

public class FibonacciTest {

@Test(expected=IllegalArgumentException.class)
public void UjemnyArgument() throws Exception{
	//given
	Fibonacci.fib(-1);
}

@Test
public void ArgumentJeden() throws Exception{
	//given
	long Wynik=Fibonacci.fib(1);
	//result
	Assert.assertEquals(1, Wynik);
}
@Test
public void ArgumentDwa() throws Exception{
	//given
	long Wynik=Fibonacci.fib(2);
	//result
	Assert.assertEquals(1, Wynik);
}
@Test
public void ArgumentZero() throws Exception{
	//given
	long Wynik=Fibonacci.fib(0);
	//result
	Assert.assertEquals(0, Wynik);
}
@Test
public void ArgumentPiec() throws Exception{
	//given
	long Wynik=Fibonacci.fib(0);
	//result
	Assert.assertEquals(0, Wynik);
}

}

