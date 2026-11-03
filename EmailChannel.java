package task3;

public class EmailChannel implements MessageChannel { public void transmit(String r,String m){System.out.printf("[EMAIL PROTOCOL -> %s]%n%s%n",r,m);} }
