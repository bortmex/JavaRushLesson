package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {

        UA ua = new UA();
        DataAdapter da = new DataAdapter(ua,ua);
        System.out.println(da.getCompany());
        System.out.println(da.getContactFirstName());
        System.out.println(da.getContactLastName());
        System.out.println(da.getCountryCode());
        System.out.println(da.getDialString());

    }

    public static class UA implements Contact, Customer {

        @Override
        public String getCompanyName() {
            return "JavaRush Ltd.";
        }

        @Override
        public String getCountryName() {
            return "Ukraine";
        }

        @Override
        public String getName() {
            return "Ivanov, Ivan";
        }

        @Override
        public String getPhoneNumber() {
            return "+38(050)123-45-67";
        }
    }
    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }
        @Override
        public String getCountryCode() {
            for(Map.Entry<String,String> count:countries.entrySet()){
                if(count.getValue().equals(customer.getCountryName())) return count.getKey();
            }
            return null;
        }
        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }
        @Override
        public String getContactFirstName() {
            return contact.getName().split(", ")[1];
        }
        @Override
        public String getContactLastName() {
            return contact.getName().split(", ")[0];
        }
        @Override
        public String getDialString() {
            return "callto://"+contact.getPhoneNumber().replaceAll("\\pP", "");
        }
    }
    public static interface RowItem {
        String getCountryCode(); //example UA
        String getCompany(); //example JavaRush Ltd.
        String getContactFirstName(); //example Ivan
        String getContactLastName(); //example Ivanov
        String getDialString(); //example callto://+380501234567
    }
    public static interface Customer {
        String getCompanyName(); //example JavaRush Ltd.
        String getCountryName(); //example Ukraine
    }
    public static interface Contact {
        String getName(); //example Ivanov, Ivan
        String getPhoneNumber(); //example +38(050)123-45-67
    }
}