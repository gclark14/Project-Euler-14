/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler14java;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Calculator {
    
    public BigInteger var = new BigInteger("1");
    public final BigInteger ZERO = new BigInteger("0");
    public final BigInteger ONE = new BigInteger("1");
    public final BigInteger TWO = new BigInteger("2");
    public final BigInteger THREE = new BigInteger("3");
    
    private final int W = 1000000;
    
    int [] catz = new int[W];
    
    public void decrease(){
        var = var.divide(TWO);
    }

    public void increase(){
        var = var.multiply(THREE).add(ONE);
    }
    
    public int calculate(int n){
        var = new BigInteger(Integer.toString(n));
        int iterations = 0; // i counts iterations until 1
        while(!var.toString().equals(ONE.toString())){
            if((var.mod(TWO)).toString().equals(ZERO.toString())) {
                decrease();
                iterations++;
            }
            else {
                increase();
                iterations++;
            } 
        }
        return iterations;
    }

    public void popList(){
        for(int i = 1; i < W; ++i){
            catz[i] = calculate(i);
        }
        findLargest();
//        displayList();
    }

    public void displayList(){
        for(int i = 1; i < catz.length; i++){
            System.out.println("catz at " + i + " " + catz[i]);
        }
    }
    
    
    public void findLargest(){
        int steps = 0;
        int index = 0;
        for(int i = 1; i < W; i++){
            if(steps < catz[i]){
                steps = catz[i];
                index = i;
            }
        }
        
        System.out.println("Steps: " + steps);
        System.out.println("Starting number: " + index);
    }
}
