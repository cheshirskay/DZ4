package com.pvt.test.collcentre;

import com.pvt.test.collcentre.client.utill.ClientDataGenerationUtill;
import java.util.concurrent.Semaphore;

public class CallCentre {

    static final int NUMBER_OF_OPERATORS_WORKING_IN_THE_CALLCENTER = 4;
    static final boolean[] CALL_CENTER_OPERATOR = new boolean[NUMBER_OF_OPERATORS_WORKING_IN_THE_CALLCENTER];
    static final int NUMBER_OF_CLIENTS_PER_DAY = 9;
    static final int MIN_SLEEP_TIME_FOR_THREAD = 300;
    static final int MAX_SLEEP_TIME_FOR_THREAD = 1000;


    // Set the "fair" flag, in which case the asquire() method will distribute solutions in order of priority
    static final Semaphore SEMAPHORE = new Semaphore(NUMBER_OF_OPERATORS_WORKING_IN_THE_CALLCENTER, true);

    public static void main(String[] args) throws InterruptedException {

        System.out.println("The call center has started working");
        // Creation of Thread (clients)
        for (int i = 1; i <= NUMBER_OF_CLIENTS_PER_DAY; i++) {
            new Thread(new СallСenterSimulationSemaphore(i, ClientDataGenerationUtill.generatingNamesClient()))
                    .start();
            Thread.sleep(MIN_SLEEP_TIME_FOR_THREAD + (int) (Math.random() * MAX_SLEEP_TIME_FOR_THREAD));
        }
    }
}