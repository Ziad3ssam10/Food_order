package com.example.demo.Models;

import com.example.demo.Main;

public class Admin extends User {
    private String Phone_number;

    public int Register(String F_name,String Email, String Password,String Phone_number) {
        if(!Email.contains("@gmail.com") || Email.length()<=10) {
            return -1;
        }
        if(Password.length()<8 ) {
            return -2;
        }
        if(F_name == null) {
            return -3;
        }
        if (Phone_number == null || Phone_number.length()!=11 || Phone_number.charAt(0)!='0' || Phone_number.charAt(1)!='1') {
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
        this.Email = Email;
        this.Password = Password;
        this.Phone_number = Phone_number;

        return 1;
    }






    public int Add_Delievry_stuff(String F_name, String L_name, String Email, String Password, String Phone_number, int age,String area,String governorate,int idx_area, int idx_gov)
    {
        Delievry_Staff delievryStaff=new Delievry_Staff();

        delievryStaff.Register(F_name,  L_name,  Email,  Password,  Phone_number, age, area, governorate);
        Main.capitals.get(idx_gov).getArea_list().get(idx_area).getDelievryStaffs().add(delievryStaff);

        return 1 ;
    }

    public int Add_Resturant(String Name , String area1,String Governorate,int area_idx,int gov_idx)
    {
        Resturant rest=new Resturant();
        rest.set_Name(Name);
        rest.set_Area(area1);
        rest.set_Governorate(Governorate);
        if(area_idx==-1||gov_idx==-1)
        {
            return -1;
        }
        Main.capitals.get(gov_idx).getArea_list().get(area_idx).getResturantlist().add(rest);
        return 1;
    }


    public void Remove_Resturant( int restindex,int areaindex,int governorateindex) {

        Main.capitals.get(governorateindex).getArea_list().get(areaindex).getResturantlist().remove(restindex);
    }




    public String get_Phone_number(){
        return this.Phone_number;
    }

    public void set_Phone_number(String phone_number){
        this.Phone_number=phone_number;
    }
}