package de.hska.iwi.vislab.lab1.example.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "de.hska.iwi.vislab.lab1.example.ws.FibonacciService")
public class FibonacciServiceImpl implements FibonacciService {

    @Override
    public int getFibonacci(int n) {
        int i = 0, j = 1, k, t;
        for (k = 1; k < n; ++k) {
            t = i + j;
            i = j;
            j = t;
        }
        return j;
    }
}
