package com.example.demo.Models;

public abstract class User {
    protected String F_name;
    protected String L_name ;
    protected String Email ;
    protected String Password ;


    public int Register(String F_name, String L_name, String Email, String Password) {
        if(!Email.contains("@gmail.com") && Email.length()<=10) {
            return -1;
        }
        if(Password.length()<8 ) {
            return -2;
        }
        if(F_name == null) {
            return -3;
        }
        if(L_name==null) {
            return -4;
        }
        for(int i=0; i<Password.length(); i++) {
            boolean flag1 = false;
            for(int j=0; j<=9; j++) {
                if((Password.charAt(i)-'0')==j){
                    flag1 = true;
                    break;
                }
            }
            if(!flag1) {
                return -5;
            }
        }
        this.F_name = F_name;
        this.L_name = L_name;
        this.Email = Email;
        this.Password = Password;

        return 1;
    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String f_name) {
        F_name = f_name;
    }

    public String get_LName() {
        return L_name;
    }

    public void setL_name(String l_name) {
        L_name = l_name;
    }

    public String get_Email() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String  get_pass() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}