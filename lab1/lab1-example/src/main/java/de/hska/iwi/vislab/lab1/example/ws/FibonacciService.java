package de.hska.iwi.vislab.lab1.example.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "de.hska.iwi.vislab.lab1.example.ws.FibonacciService")
public interface FibonacciService {
    public int getFibonacci(@WebParam(name = "index")int n);
}
