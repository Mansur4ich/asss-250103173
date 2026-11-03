package task3;

public class SmsChannel implements MessageChannel { public void transmit(String r,String m){System.out.printf("[SMS PROTOCOL -> %s] %s%n",r,m.replace("\n"," -- "));} }
