package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip); //11000000 10101000 00000001 00000010
        print(mask); //11111111 11111111 11111110 00000000
        print(netAddress); //11000000 10101000 00000000 00000000
    }
    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAdres = new byte[4];
        netAdres[0] = (byte) (ip[0]&mask[0]);
        netAdres[1] = (byte) (ip[1]&mask[1]);
        netAdres[2] = (byte) (ip[2]&mask[2]);
        netAdres[3] = (byte) (ip[3]&mask[3]);
        return netAdres;
    }
    public static void print(byte[] bytes) {
//System.out.println(String.format("%8.8s %8.8s %8.8s %8.8s",Integer.toBinaryString(bytes[0]),Integer.toBinaryString(bytes[1]),Integer.toBinaryString(bytes[2]),Integer.toBinaryString(bytes[3])));
        System.out.println(String.format("%08d %08d %08d %08d",Convert(bytes[0]),Convert(bytes[1]),Convert(bytes[2]),Convert(bytes[3])));
    }
    public static int Convert(byte byter){
        String s1 = String.format("%8s", Integer.toBinaryString(byter & 0xFF)).replace(' ', '0');
        return Integer.parseInt(s1);
    }
}