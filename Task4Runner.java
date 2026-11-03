package task4;

public class Task4Runner {public static void main(String[] args){LegacyForeignOrder order=new LegacyForeignOrder("ORD-9821",100);PricingService base=new CurrencyOrderAdapter(order,new LegacyCurrencyConverter(),"USD");System.out.printf("Base Converted: $%.2f%n",base.calculateTotal());PricingService checkout=new CustomsDutyDecorator(new ExpressCourierDecorator(new GiftWrapDecorator(base)));System.out.println("\n>>> INVOICE BREAKDOWN <<<");System.out.println(checkout.getReceiptBreakdown());System.out.printf("FINAL CHARGE TOTAL: $%.2f%n",checkout.calculateTotal());} }
