package com.javarush.task.task19.task1903;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by rogov on 06.07.2017.
 */
public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {
       /* IncomeData us = new UA();
        IncomeDataAdapter incomeUS = new IncomeDataAdapter(us);
        System.out.println(incomeUS.getName());
        System.out.println(incomeUS.getPhoneNumber());
        System.out.println(incomeUS.getCompanyName());
        System.out.println(incomeUS.getCountryName());*/
    }
    public static class UA implements IncomeData{
        @Override
        public String getCountryCode() {
            return "UA";
        }
        @Override
        public String getCompany() {
            return "JavaRush Ltd";
        }
        @Override
        public String getContactFirstName() {
            return "Ivan";
        }
        @Override
        public String getContactLastName() {
            return "Ivanov";
        }
        @Override
        public int getCountryPhoneCode() {
            return 38;
        }
        @Override
        public int getPhoneNumber() {
            return 501234567;
        }
    }
    public static class IncomeDataAdapter implements Customer, Contact {
        private static final MessageFormat phoneFormatM = new MessageFormat("({0}){1}-{2}-{3}");
        private IncomeData data;
        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }
        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }
        @Override
        public String getPhoneNumber() {
            String number = String.format("%010d", data.getPhoneNumber());
            String[] arrPhone = {number.substring(0,3), number.substring(3,6), number.substring(6,8), number.substring(8,10)};
//String.format("%010d",(data.getPhoneNumber())).replaceFirst("(\\d{3})(\\d{3})(\\d{2})(\\d+)", "($1)$2-$3-$4");
            return String.format("%+d%s", data.getCountryPhoneCode(),phoneFormatM.format(arrPhone));
        }
        @Override
        public String getCompanyName() {
            return data.getCompany();
        }
        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode(); //example UA
        String getCompany(); //example JavaRush Ltd.
        String getContactFirstName(); //example Ivan
        String getContactLastName(); //example Ivanov
        int getCountryPhoneCode(); //example 38
        int getPhoneNumber(); //example 501234567
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