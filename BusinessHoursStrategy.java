package task3;

public class BusinessHoursStrategy implements DispatchStrategy { public boolean shouldDispatch(int s,int h){return s>=5 || (h>=9 && h<=17);}public String getStrategyName(){return "BUSINESS_HOURS_ONLY (09:00 - 17:00)";} }
