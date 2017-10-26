package de.hska.iwi.vislab.lab1.example.ws;

import javax.jws.*;

/** Dienst-Interface */
@WebService
public interface FibonacciServiceIntf {

    int getFibonacci(int index);
}