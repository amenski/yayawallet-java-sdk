package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Time {

    private long time;
    private String timezone;
    @JsonProperty("client_ip")
    private String clientIp;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
}
