package task4;

public class LegacyCurrencyConverter {public double convert(double amount,String from,String to){return "GBP".equalsIgnoreCase(from)&&"USD".equalsIgnoreCase(to)?amount*1.25:amount;} }
