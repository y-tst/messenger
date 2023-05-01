package com.epam.ld.module2.testing;

/**
 * The type Client.
 */
public class Client {
    private String addresses;
    private String name;
    private String email;

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Gets addresses.
     *
     * @return the addresses
     */
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }

    /**
     * Sets addresses.
     *
     * @param email the addresses
     */
    public void setEmail(String email) {
        this.addresses = addresses;
    }

    public void setName(String name) {
        this.name = name;
    }
}
