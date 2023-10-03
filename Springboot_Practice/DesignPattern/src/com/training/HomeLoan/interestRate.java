package com.training.HomeLoan;

abstract class interestRate {
	protected double rate;
	abstract void getRate();
	public void calculateBill(int amount,int years) {
		 double monthlyInterestRate = rate / 12 / 100;
        int numberOfPayments = years * 12;
        double monthlyEmi = (amount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        System.out.println("Monthly EMI: " + monthlyEmi);
	}
}
