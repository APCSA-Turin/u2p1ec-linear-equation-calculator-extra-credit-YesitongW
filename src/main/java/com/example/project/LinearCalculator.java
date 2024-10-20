package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
    
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1=0;
    private int x2=0;
    private int y1=0;
    private int y2=0;

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String point1, String point2){ // <--add 2 string parameters to this constructor
     this.x1=Integer.parseInt(point1.substring(1,point1.indexOf(","))); //pull out value of x1
     this.y1=Integer.parseInt(point1.substring(point1.indexOf(",")+1,point1.indexOf(")"))); //pull out value of y1
     this.x2=Integer.parseInt(point2.substring(1,point2.indexOf(","))); //pull out value of x2
     this.y2=Integer.parseInt(point2.substring(point2.indexOf(",")+1,point2.indexOf(")"))); //pull out value of y2
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    /*set int x1,2 y1,2 to a val */
    public void setX1(int x1){this.x1 = x1;}
    public void setY1(int y1){this.y1 = y1;}
    public void setX2(int x2){this.x2 = x2;}
    public void setY2(int y2){this.y2 = y2;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double dist = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));//distance formula
        return roundedToHundredth(dist); //round to 100th place
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        double slope = slope();
        if (slope == -999.99){return -999.99;} //slope method
        return roundedToHundredth (y1 - slope()* x1); 
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
       if (x2-x1 == 0){return -999.99;} //if denominator is 0 the slope will be UNF, return -999.99
       double slope =(double) (y2-y1)/(x2-x1); 
       return roundedToHundredth(slope);
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
    if (yInt() == -999.99) {return "undefined";}
    else if (yInt() == 0) {return "y=" + slope() + "x";} //only return function with slope
    else if (slope() == 0) {return "y=" + yInt();} //only return function with y-int
    else if (yInt() < 0) {return "y=" + slope() + "x" + yInt();} //if y-int is negetive then no need to print out + after x
    else {return "y=" + slope() + "x+" + yInt();} 
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return Math.round(x*100.0) / 100.0;
    }

    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\nThe distance between the two points is:" + distance();
        str += "\n"+ findSymmetry();
        str += "\n"+ Midpoint();
        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        /*I got the idea from https://www.wikihow.com/Tell-if-a-Function-Is-Even-or-Odd */
        if (y1 == -(y2) && x1 == x2) {return "Symmetric about the x-axis";} 
        else if (y1 == y2 && x1 == -(x2)) {return "Symmetric about the y-axis";}
        else if (y1 == -(y2) && x1 == -(x2)) {return "Symmetric about the origin";}
        else {return "No symmetry";}
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        return "The midpoint of this line is: ("+ (double)(x1+x2)/2 + "," + (double)(y1+y2)/2 + ")"; //midpoint formula
    }
}



