public class SmartDevice {
    private static int _deviceCounter = 0;

    private int _deviceId;
    private String _deviceName;
    private boolean _isOnline;

    public SmartDevice(String deviceName, boolean isOnline) {
        _deviceName = deviceName;
        _isOnline = isOnline;

        _deviceId = _deviceCounter;
        _deviceCounter++;
    }

    public SmartDevice() {
        _deviceId = _deviceCounter;
        _deviceCounter++;
    }

    public String getDeviceName() {
        return _deviceName;
    }

    public boolean getIsOnline() {
        return _isOnline;
    }

    public void setDeviceName(String deviceName) {
        _deviceName = deviceName;
    }

    public void setIsOnline(boolean isOnline) {
        _isOnline = isOnline;
    }

    @Override
    public boolean equals(Object obj2) {
        if (obj2 == null) {
            return false;
        }

        if (!(obj2 instanceof SmartDevice)) {
            return false;
        }

        SmartDevice castedObj = (SmartDevice) obj2;
        return castedObj._deviceId == this._deviceId;
    }

    @Override
    public String toString() {
        return String.format("[ID = %s, Name = %s, ON = %s]", _deviceId, _deviceName, _isOnline);
    }

    public void toggleStatus() {
        _isOnline = !_isOnline;
    }

    public static int getTotalDevices() {
        return SmartDevice._deviceCounter;
    }
}