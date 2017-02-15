package com.capgemini.fibonacci;
//class that calculates fibonacci for given argument
public class Fibonacci {
	public static long fib(int n) throws IllegalArgumentException {
		long number1=1;
		long number2=1;
		long numbern=0;
		if (n<0){
			throw new IllegalArgumentException();
		}
		if (n==0){
			return 0;
		}else if (n<=2){
			return 1;
		}else if (n>2){
			for (int i=3;i<=n;i++){
				numbern=number1+number2;
				number1=number2;
				number2=numbern;
				if (numbern<0){ 
					throw new IllegalArgumentException();					
				}
			}
			return numbern;
		}
        return 0;
    }

}
