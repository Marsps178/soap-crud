package cibertec.pe.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface ICalculator {

    @WebMethod
    int add(int num1, int num2);

    @WebMethod
    int subtract(int num1, int num2);
    @WebMethod
    int multiply(int num1, int num2);
    @WebMethod
    double divide(int num1, int num2);

    



}
