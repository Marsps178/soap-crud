package cibertec.pe.service;

import jakarta.jws.WebService;

@WebService
public class CalculatorImplement implements ICalculator {

    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public double divide(int num1, int num2) {
        return (double) num1 / num2;
    }

}
