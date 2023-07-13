package com.frame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;


public class render_name_medicare_ID {

    public String firtname () {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int len = 4;
        Random random = new Random();
        String firstname = random.ints(leftLimit, rightLimit + 1)
                .limit(len)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return firstname;
    }

    public String lastname () {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int len = 5;
        Random random = new Random();
        String lastname = random.ints(leftLimit, rightLimit + 1)
                .limit(len)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return lastname;
    }

    public static String medicare_ID() {
//        int leftLimit = 97; // letter 'a'
//        int rightLimit = 122; // letter 'z'
//        int len = 2;
        String[] character = {"A","C","H","J","K","M","N","P","R","T","Y"};

        Random random = new Random();
        String generatedString1 = character[random.nextInt(character.length)];
        String generatedString2 = character[random.nextInt(character.length)];
        String generatedString3 = character[random.nextInt(character.length)];
        String generatedString4 = character[random.nextInt(character.length)];
        String generatedString5 = character[random.nextInt(character.length)];
        String generatedString6 = character[random.nextInt(character.length)];
        int value1 = random.nextInt(9) +1;
        int value2 = random.nextInt(9)+1;
        int value3 = random.nextInt(9)+1;
        int code = (int) Math.floor(((Math.random() * 89) + 10));
        String medicare_ID = value1 + generatedString1 + generatedString2
                +value2 + generatedString3 + generatedString4
                +value3 + generatedString5 + generatedString6 + code;
        return medicare_ID;
    }

    public static void main(String a[]) {
        for (int i= 0; i < 1000; i++ ) {
            System.out.println("<test name=\"TC"+ i +": genetics\">");
            System.out.println("<classes>");
            System.out.println("<class name=\"com.scripts.Genetics\">");
            System.out.println("<methods>");
            System.out.println("<include name=\"genetics1\"></include>");
            System.out.println("</methods>");
            System.out.println("</class>");
            System.out.println("</classes>");
            System.out.println("</test>");
        }
    }
}
