public class ThermostatAdapter implements SmartDevice {

    private final LegacyThermostat thermostat;

    public ThermostatAdapter(LegacyThermostat thermostat) {
        if (thermostat == null) {
            throw new IllegalArgumentException("LegacyThermostat cannot be null");
        }
        this.thermostat = thermostat;
    }

    @Override
    public void turnOn() {
        String state = thermostat.checkDial();
        if ("IDLE".equals(state)) {
            thermostat.rotateDial("LOW");
        }
    }

    @Override
    public void turnOff() {
        thermostat.rotateDial("IDLE");
    }

    @Override
    public boolean isOn() {
        String state = thermostat.checkDial();

        if (state == null) {
            return false;
        }

        return state.equals("LOW")
                || state.equals("MEDIUM")
                || state.equals("MAX");
    }

    @Override
public int getPowerPercent() {
    String state = thermostat.checkDial();

    if (state == null) {
        return -1;
    }

    if (state.equals("IDLE")) {
        return 0;
    }

    if (state.equals("LOW")) {
        return 33;
    }

    if (state.equals("MEDIUM")) {
        return 66;
    }

    if (state.equals("MAX")) {
        return 100;
    }

    return -1;
}
}
