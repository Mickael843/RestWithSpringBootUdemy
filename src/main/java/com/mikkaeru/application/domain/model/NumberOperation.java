package com.mikkaeru.application.domain.model;

public class NumberOperation {
	
	private Double numberOne;
	private Double numberTwo;
	
	public Double getNumberOne() {
		return numberOne;
	}
	public void setNumberOne(Double numberOne) {
		this.numberOne = numberOne;
	}
	public Double getNumberTwo() {
		return numberTwo;
	}
	public void setNumberTwo(Double numberTwo) {
		this.numberTwo = numberTwo;
	}
	
	public Double sum() {
		return numberOne + numberTwo;
	}

	public Double subtraction() {
		return numberOne - numberTwo;
	}

	public Double multiplication() {
		return numberOne * numberTwo;
	}

	public Double division() {
		return numberOne / numberTwo;
	}

	public Double mean() {
		return (numberOne + numberTwo) / 2;
	}

	public Double squareRoot() {
		return Math.sqrt(this.numberOne);
	}
}
