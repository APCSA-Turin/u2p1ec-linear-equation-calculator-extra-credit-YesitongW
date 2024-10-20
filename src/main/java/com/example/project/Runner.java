package com.example.project;
public class Runner{
    public static void main(String[] args) {
        LinearCalculator c = new LinearCalculator("(3,4)","(3,-4)");
        String studentOutput = c.Midpoint();
        System.out.println(studentOutput);
    }
}