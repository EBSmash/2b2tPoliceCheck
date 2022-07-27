package com.lambda.util;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FriendManager {
    static ArrayList<String> usernames = new ArrayList<>();
    static int index = 0;


    public static List<String> getRawPastebin(String pasteKey){

        try {
            URL url = new URL("https://pastebin.com/raw/" + pasteKey);
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()){
                usernames.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usernames;

    }

    static List<String> pastebinNameList = getRawPastebin("8aJ7KgE8");
    public static boolean isFriendly(String username) {
        for (String pastebinName : pastebinNameList) {
            if(pastebinName.toLowerCase(Locale.ROOT).contains(username.toLowerCase(Locale.ROOT))){
                return true;
            }
        }
        return false;
    }

    public static String getName(String username) {
    for (String pastebinName : pastebinNameList) {
            if(pastebinName.toLowerCase(Locale.ROOT).contains(username.toLowerCase(Locale.ROOT))){
                return pastebinName;
            }
        }
        return null;
        }
    }

