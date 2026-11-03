package task3;

public class DailySummaryAlert extends Alert { public DailySummaryAlert(MessageChannel c,DispatchStrategy s){super(c,s);}public int getSeverityLevel(){return 1;}public String formatAlertBody(String raw){return "Daily Digest:\n"+raw;} }
