package de.hska.iwi.vislab.lab1.example.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "de.hska.iwi.vislab.lab1.example.ws.FibonacciServiceImpl")
public class FibonacciServiceImpl implements FibonacciServiceIntf {

    @Override
    public int getFibonacci(int index) {
        return 0;
    }
}
