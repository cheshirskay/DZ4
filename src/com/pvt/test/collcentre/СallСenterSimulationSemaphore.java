package com.pvt.test.collcentre;


import com.pvt.test.collcentre.client.Client;

import static com.pvt.test.collcentre.CallCentre.CALL_CENTER_OPERATOR;
import static com.pvt.test.collcentre.CallCentre.SEMAPHORE;

public class СallСenterSimulationSemaphore extends Client implements Runnable {
    public СallСenterSimulationSemaphore(int clientNumber, String clientName) {
        super(clientNumber, clientName);
    }

    static final int VARIABLE_FOR_BEAUTIFUL_OUTPUT = 1;
    static final int MIN_SLEEP_TIME_FOR_THREAD = 3000;
    static final int MAX_SLEEP_TIME_FOR_THREAD = 5000;

    @Override
    public void run() {
        System.out.println("Сlient " + getClientName() + " called the call center and is waiting for a connection");
        try {

            //acquire() requests access to the block of code following the call to this method,
            //if access is denied, the thread that called this method blocks until
            //until the semaphore grants access
            SEMAPHORE.acquire();

            int operatorNumber = -1;

            // select a free operator and connect
            synchronized (CALL_CENTER_OPERATOR) {
                for (int i = 0; i <= CALL_CENTER_OPERATOR.length; i++)
                    if (!CALL_CENTER_OPERATOR[i]) {      //if there is a free operator
                        CALL_CENTER_OPERATOR[i] = true;  //connect with him

                        operatorNumber = i;

                        System.out.println("Сlient " + getClientName() + " connected to the operator " +
                                (i + VARIABLE_FOR_BEAUTIFUL_OUTPUT));
                        break;
                    }
            }
            Thread.sleep(MIN_SLEEP_TIME_FOR_THREAD + (int) (Math.random() *
                    MAX_SLEEP_TIME_FOR_THREAD));       //talk

            synchronized (CALL_CENTER_OPERATOR) {
                CALL_CENTER_OPERATOR[operatorNumber] = false;//end the conversation
                System.out.println("operator " + (operatorNumber + VARIABLE_FOR_BEAUTIFUL_OUTPUT) +
                        " ended the conversation");
            }
            for (int j = 0, k = 0; j < CALL_CENTER_OPERATOR.length; j++)
                if (CALL_CENTER_OPERATOR[j] == false) {
                    k++;
                    if (k == CALL_CENTER_OPERATOR.length) {
                        System.out.println("Сall center closed ");
                    }
                }
            //release(), releases the resource
            SEMAPHORE.release();

        } catch (InterruptedException e) {
        }
    }
}
