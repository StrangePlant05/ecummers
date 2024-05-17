package com.example.ecummerce;

public class FirebaseInterface {
    public interface EmailAuth{
        void changeLayout(boolean change);
    }
    public interface LoginComplete{
        void loginSuccess(boolean allow);
    }
    public interface DuplicatePhoneNumber{
        void allowSignup(boolean nodupe);
    }
    public interface ProductAdded{
        void addID(String addID);
    }
}
