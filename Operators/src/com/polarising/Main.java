package com.polarising;

public class Main {

    public static void main(String[] args) {

        int result = 1 + 2;
        System.out.println("result = " + result);

        int previousResult = result;
        System.out.println("previousResult = " + previousResult);

        result = result - 1;
        System.out.println("result = " + result);
        System.out.println("previousResult = " + previousResult);

        result = result * 10;
        System.out.println("result = " + result);

        result = result / 5;
        System.out.println("result = " + result);

        result = result % 3;
        System.out.println("result = " + result);

        result++;
        System.out.println("result = " + result);

        result--;
        System.out.println("result = " + result);

        result += 2;
        System.out.println("result = " + result);

        result *= 10;
        System.out.println("result = " + result);

        boolean isAlien = false;

        if (isAlien == false) {
            System.out.println("It is not an alien!");
            System.out.println("And I am scared of aliens");
        }

        int topScore = 80;
        if(topScore < 100){
            System.out.println("You got the high score");
        }

        int secondTopScore = 81;
        if((topScore > secondTopScore) && (topScore < 100)){
            System.out.println("Greater than second top score and less than 100");
        }

        if((topScore > 90) || (secondTopScore <= 90)){
            System.out.println("Either or both of the conditions are true");
        }

        int newValue = 50;
        if(newValue == 50){
            System.out.println("This is true");
        }

        boolean isCar = false;
        if(isCar){
            System.out.println("This is not supposed to happen");
        }

        isCar = true;
        boolean wasCar = isCar ? true : false;
        if(wasCar){
            System.out.println("wasCar is true");
        }

        double myFirstValue = 20d;
        double mySecondValue = 80d;
        double myValuesTotal = (myFirstValue + mySecondValue) * 100d;
        System.out.println("myValuesTotal = " + myValuesTotal);

        double theRemainder = myValuesTotal % 40d;
        System.out.println("theRemainder = " + theRemainder);

        boolean isNoRemainder = (theRemainder == 0) ? true : false;
        System.out.println("isNoRemainder = " + isNoRemainder);

        if(!isNoRemainder){
            System.out.println(" Got some remainder");
        }
    }
}
