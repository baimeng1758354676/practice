package com.example.demo.util;

import java.util.Random;

public class RandomUtil {
    public static String getRandom(int length) {

        StringBuilder val = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {

            val.append(random.nextInt(10));

        }
        return val.toString();
    }
}

