public class SmartLight extends SmartDevice {
    private int _brightnessLevel;

    public SmartLight(String deviceName, boolean isOnline, int brightnessLevel) {
        super(deviceName, isOnline);
        _brightnessLevel = brightnessLevel;
    }

    public SmartLight(int brightnessLevel) {
        super();
        _brightnessLevel = brightnessLevel;
    }

    @Override
    public void toggleStatus() {
        super.toggleStatus();
        if (!super.getIsOnline()) {
            _brightnessLevel = 0;
        }
    }

    @Override
    public String toString() {
        String deviceData = super.toString();
        return String.format("%s , [Brightness Lev = %s]", deviceData, _brightnessLevel);
    }
}
