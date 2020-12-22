package com.polarising;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int value = 1;

        if(value == 1){
            System.out.println("Value was 1");
        } else if (value == 2){
            System.out.println("Value was 2");
        } else{
            System.out.println("Value was not 1 or 2");
        }

        int switchValue = 5;

        switch (switchValue){
            case 1:
                System.out.println("SwitchValue was 1");
                break;
            case 2:
                System.out.println("SwitchValue was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("SwitchValue was a 3, or a 4, or a 5");
                System.out.println("Actually, SwitchValue was a " + switchValue);
                break;
            default:
            System.out.println("SwitchValue was not 1 or 2");
            break;
        }

        char switchChar = 'D';

        switch (switchChar){
            case 'A':
                System.out.println("switchChar is A");
                break;
            case 'B':
                System.out.println("switchChar is B");
                break;
            case 'C': case 'D': case 'E':
                System.out.println(switchChar + " was found");
                break;
            default:
                System.out.println("Not found");
                break;
        }

        String month = "JANuary";

        switch (month.toLowerCase()){
            case "january":
                System.out.println("Jan");
                break;
            case "bebruary":
                System.out.println("Feb");
                break;
            default:
                System.out.println("Not found");
                break;
        }

    }
}
