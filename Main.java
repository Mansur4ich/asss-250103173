import java.util.List;

import java.util.Arrays;
public class Main {

    public static void main(String[] args) {

        System.out.println("====================================================");
        System.out.println("        OMNIHOME SMART CONTROLLER: SYSTEM STARTUP");
        System.out.println("====================================================");

        LegacyBulb rawBulb = new LegacyBulb();
        LegacyThermostat rawThermostat = new LegacyThermostat();

        SmartDevice bulbAdapter = new BulbAdapter(rawBulb);
        SmartDevice thermostatAdapter = new ThermostatAdapter(rawThermostat);

        System.out.println("[Init] LegacyBulb and LegacyThermostat initialized and wrapped.");

        List<SmartDevice> deviceList = Arrays.asList(bulbAdapter, thermostatAdapter);

        System.out.println("[Hub] Registering 2 adapted devices into ModernHub...");

        ModernHub hub = new ModernHub(deviceList);

        // ModernHub badHub = new ModernHub(List.of(rawBulb)); // COMPILE ERROR
        /*
         * The compiler rejects this because LegacyBulb does not implement SmartDevice,
         * while ModernHub requires a List<SmartDevice>.
         * The Object Adapter pattern solves this by wrapping LegacyBulb inside
         * BulbAdapter, which implements SmartDevice without modifying LegacyBulb.
         */

        System.out.println();
        System.out.println("--- OPERATION: ACTIVATE ALL DEVICES ---");

        hub.activateAll();

        System.out.println("[Action] ModernHub.activateAll() invoked.");
        System.out.println(" -> BulbAdapter: Brightness set to " + rawBulb.readBrightness() + ".");
        System.out.println(" -> ThermostatAdapter: Dial set to '" + rawThermostat.checkDial() + "'.");

        boolean allActive = bulbAdapter.isOn() && thermostatAdapter.isOn();
        System.out.println("[Status] All devices reported active: " + allActive);

        System.out.printf(
                "[Power] Fleet Average Power Usage: %.2f%% (Bulb: %d%%, Thermostat: %d%%)%n",
                hub.calculateAveragePowerUsage(),
                bulbAdapter.getPowerPercent(),
                thermostatAdapter.getPowerPercent()
        );

        System.out.println();
        System.out.println("--- AUDIT: HARDWARE FAULT INJECTION (STAGE 4) ---");

        rawBulb.breakFilament();

        System.out.println("[Fault 1] Filament physically severed on LegacyBulb...");
        System.out.println(" -> BulbAdapter.isOn(): " + bulbAdapter.isOn());
        System.out.println(" -> BulbAdapter.getPowerPercent(): "
                + bulbAdapter.getPowerPercent() + "%");

        rawThermostat.rotateDial("STUCK");

        System.out.println();
        System.out.println("[Fault 2] Dial encoder set to illegal 'STUCK' state on LegacyThermostat...");
        System.out.println(" -> ThermostatAdapter.isOn(): " + thermostatAdapter.isOn());
        System.out.println(" -> ThermostatAdapter.getPowerPercent(): "
                + thermostatAdapter.getPowerPercent());

        System.out.println();
        System.out.println("--- OPERATION: EMERGENCY SHUTDOWN ---");

        hub.emergencyShutdown();

        System.out.println("[Action] ModernHub.emergencyShutdown() invoked.");
        System.out.println(" -> BulbAdapter: Brightness set to " + rawBulb.readBrightness() + ".");
        System.out.println(" -> ThermostatAdapter: Dial rotated to '" + rawThermostat.checkDial() + "'.");
        System.out.printf(
                "[Power] Fleet Average Power Usage: %.2f%%%n",
                hub.calculateAveragePowerUsage()
        );

        System.out.println("System started");
    }
}
