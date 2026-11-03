package task4;

public abstract class PricingDecorator implements PricingService {protected final PricingService wrappedService;public PricingDecorator(PricingService s){if(s==null)throw new IllegalArgumentException();wrappedService=s;}public double calculateTotal(){return wrappedService.calculateTotal();}public String getReceiptBreakdown(){return wrappedService.getReceiptBreakdown();} }
