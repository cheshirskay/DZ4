package com.pvt.test.collcentre.client;

public class Client {

    private static final String DEFAULT_VALUE_STRING = "Not entered";
    private static final int DEFAULT_VALUE_INT = 0;
    private int clientNumber;
    private String clientName;

    public Client() {
        this.clientNumber = DEFAULT_VALUE_INT;
        this.clientName = DEFAULT_VALUE_STRING;
    }

    public Client(int clientNumber, String clientName) {
        this.clientNumber = clientNumber;
        this.clientName = clientName;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (clientNumber != client.clientNumber) return false;
        return clientName != null ? clientName.equals(client.clientName) : client.clientName == null;
    }

    @Override
    public int hashCode() {
        int result = clientNumber;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return clientName;
    }
}
