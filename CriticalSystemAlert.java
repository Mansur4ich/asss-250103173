package task3;

public class CriticalSystemAlert extends Alert { public CriticalSystemAlert(MessageChannel c,DispatchStrategy s){super(c,s);}public int getSeverityLevel(){return 5;}public String formatAlertBody(String raw){return "!!! CRITICAL PRODUCTION ALERT !!!\nIncident Report: "+raw+"\nACTION REQUIRED: SRE on-call immediate intervention.";} }
