package com.capgemini.fibonacci;
//Klasa wyliczajaca iteracyjnie n-ty wyraz ciagu fibonacciego
public class Fibonacci {
	public static long fib(int n) throws IllegalArgumentException {
		long wyraz1=1;
		long wyraz2=1;
		long wyrazn=0;
		if (n<0 || n>92){
			throw new IllegalArgumentException();
		}
		if (n==0){
			return 0;
		}else if (n<=2){
			return 1;
		}else if (n>2){
			for (int i=3;i<=n;i++){
				wyrazn=wyraz1+wyraz2;
				wyraz1=wyraz2;
				wyraz2=wyrazn;
			}
			return wyrazn;
		}
        return 0;
    }

}
