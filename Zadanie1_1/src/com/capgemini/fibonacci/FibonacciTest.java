package com.capgemini.fibonacci;

import org.junit.Test;
import org.junit.Assert;

public class FibonacciTest {

@Test(expected=IllegalArgumentException.class)
public void ShouldThrowExecpetionWhenArgumentSmallerThanZero() throws Exception{
	//given
	Fibonacci.fib(-1);
}

@Test
public void ShouldReturn1ForArgument1() throws Exception{
	//given
	long Wynik=Fibonacci.fib(1);
	//result
	Assert.assertEquals(1, Wynik);
}
@Test
public void ShouldReturn1ForArgument2() throws Exception{
	//given
	long Wynik=Fibonacci.fib(2);
	//result
	Assert.assertEquals(1, Wynik);
}
@Test
public void ShouldReturn0ForArgument0() throws Exception{
	//given
	long Wynik=Fibonacci.fib(0);
	//result
	Assert.assertEquals(0, Wynik);
}
@Test
public void ShouldReturn55ForArgument10() throws Exception{
	//given
	long Wynik=Fibonacci.fib(10);
	//result
	Assert.assertEquals(55, Wynik);
}
@Test(expected=IllegalArgumentException.class)
public void ShouldThrowExecpetionWhenArgumentBiggerThanLimmit() throws Exception{
	//given
	Fibonacci.fib(97);
}

}

