package com.example.garbageiot;

public class dustbin_info {
    String dustbinname;

    public dustbin_info(String dustbinname, String percentfilled) {
        this.dustbinname = dustbinname;
        this.percentfilled = percentfilled;
    }

    String percentfilled;

    float lat,lng;

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public void setDustbinname(String dustbinname) {
        this.dustbinname = dustbinname;
    }

    public void setPercentfilled(String percentfilled) {
        this.percentfilled = percentfilled;
    }

    public String getDustbinname() {
        return dustbinname;
    }

    public String getPercentfilled() {
        return percentfilled;
    }


    dustbin_info()
    {}

}
