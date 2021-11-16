package business.entities;

import business.exceptions.UserException;
import business.persistence.OrderMapper;

import java.util.ArrayList;
import java.util.List;

public class User
{
    private int id; // just used to demo retrieval of autogen keys in UserMapper
    private String email;
    private String password; // Should be hashed and secured
    private String fname;
    private String lname;
    private float balance;
    private String role;
    private int orderCount;


    public User(String email, String password, String fname, String lname, float balance, String role)
    {
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.balance = balance;
        this.role = role;
        this.orderCount = 0;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
