package task4;

public class ExpressCourierDecorator extends PricingDecorator {public ExpressCourierDecorator(PricingService s){super(s);}public double calculateTotal(){return super.calculateTotal()+15;}public String getReceiptBreakdown(){return super.getReceiptBreakdown()+" + [Express Courier: $15.00]";} }
