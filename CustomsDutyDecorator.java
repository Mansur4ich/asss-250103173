package task4;

public class CustomsDutyDecorator extends PricingDecorator {public CustomsDutyDecorator(PricingService s){super(s);}public double calculateTotal(){return java.math.BigDecimal.valueOf(super.calculateTotal()).multiply(new java.math.BigDecimal("1.085")).setScale(2,java.math.RoundingMode.HALF_UP).doubleValue();}public String getReceiptBreakdown(){return super.getReceiptBreakdown()+" + [Customs Duty: 8.5%]";} }
