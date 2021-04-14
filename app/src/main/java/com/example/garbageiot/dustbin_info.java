package com.example.garbageiot;

public class dustbin_info {
    String dustbinname;

    public dustbin_info(String dustbinname, String percentfilled) {
        this.dustbinname = dustbinname;
        this.percentfilled = percentfilled;
    }

    String percentfilled;

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
