package com.pvt.test.collcentre.client.utill;


import com.pvt.test.collcentre.client.ClientNameLibrary;

public class ClientDataGenerationUtill {
    public static String generatingNamesClient() {

        int position = (int) (Math.random() * ClientNameLibrary.NAME_LIBRARY.length);
        return ClientNameLibrary.NAME_LIBRARY[position];
    }
}
