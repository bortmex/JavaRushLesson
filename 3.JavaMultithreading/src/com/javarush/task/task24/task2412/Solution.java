package com.javarush.task.task24.task2412;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Знания - сила!
*/
public class Solution {
    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"closed {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, null, dateFormat, fileform};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(pattform.format(testArgs));
        }
    }

    public static void sort(List<Stock> list) {
        Collections.sort(list, new Comparator<Stock>() {
            public int compare(Stock stock1, Stock stock2) {
                /*int x1 = (int)stock1.get("name").hashCode();
                Date x2 = (Date) stock1.get("date");
                double x3 = (double) stock1.get("open");
                double x4 = (double) stock1.get("last");
                String y1 = (String) stock2.get("name");
                Date y2 = (Date) stock2.get("date");
                double y3 = (double) stock2.get("open");
                double y4 = (double) stock2.get("last");*/

                int intStr = ((String) (stock1.get("name"))).compareTo((String) (stock2.get("name")));
                int intDate = getDateForCompare((Date) stock1.get("date")) - getDateForCompare((Date) stock2.get("date"));
                double intStock1 = 0;
                double intStock2 = 0;
                try {
                    intStock1 = (double) stock1.get("open") - (double) stock1.get("last");
                } catch (NullPointerException e) {
                    intStock1 = (double) stock1.get("change");
                }
                try {
                    intStock2 = (double) stock2.get("open") - (double) stock2.get("last");
                } catch (NullPointerException e) {
                    intStock2 = (double) stock2.get("change");
                }


                if (intStr > 0) return 1;
                else if (intStr == 0) {
                    if (intDate > 0) return 1;
                    else if (intDate == 0) {
                        if((intStock1-intStock2)>0)return 1;
                        else if(intStock1-intStock2==0) return 0;
                        else return -1;
                    } else return -1;
                } else return -1;
            }
        });
    }

    public static int getDateForCompare(Date date) {
        SimpleDateFormat formatY = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatM = new SimpleDateFormat("MM");
        SimpleDateFormat formatD = new SimpleDateFormat("dd");

        int intdaY = Integer.parseInt(formatY.format(date));
        int intdaM = Integer.parseInt(formatM.format(date));
        int intdaD = Integer.parseInt(formatD.format(date));

        return intdaY * 365 + intdaM * 31 + intdaD;
    }

    public static class Stock extends HashMap {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(2020));
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 128.64, 123.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));

        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year = startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}