package task3;

public class ImmediateStrategy implements DispatchStrategy { public boolean shouldDispatch(int s,int h){return true;}public String getStrategyName(){return "IMMEDIATE_DISPATCH";} }
