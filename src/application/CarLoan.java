package application;

import java.lang.Math;

public class CarLoan {
	private double carPrice;
	private double downPayment;
	private double interestRate;
	
	// constructor
	public CarLoan(double carPrice,double downPayment, double interestRate) {
		this.carPrice = carPrice;
		this.downPayment = downPayment;
		this.interestRate = interestRate;
	}
	
	// set car price
	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}
	
	// return car price
	public double getcarPrice() {
		return carPrice;
	}
	
	// set down payment
	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}
	
	// return down paymen
	public double getDownPayment() {
		return downPayment;
	}

	
	// set interest rate
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate; // set user input
	}
	
	// return interest rate
	public double getInterestRate() {
		return interestRate;
	}
	
	// get monthly loan term
	public int getMonthlyLoanTerm(int loanTerm) {
		return loanTerm*12;
	}
	
	// calculate monthly payment
	public double getMonthlyPayment(int loanTerm) {
		double loanAmount = carPrice - downPayment;
		double monthlyInterestRate = (interestRate/100)/12;
		int monthlyLoanTerm = loanTerm*12;
		return loanAmount * ((monthlyInterestRate
				* Math.pow(1+monthlyInterestRate, monthlyLoanTerm)))
				/ (Math.pow(1+monthlyInterestRate, monthlyLoanTerm) - 1);
	}
	
	// get total lifetime payment
	public double getTotalPayment(int numberOfPayments) {
		double loanAmount = carPrice - downPayment;
		double monthlyInterestRate = (interestRate/100)/12;
		return (monthlyInterestRate * loanAmount * numberOfPayments)/(1 - Math.pow(1+monthlyInterestRate, -numberOfPayments));
	}

}
