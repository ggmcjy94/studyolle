package com.studyolle.modules.account.form;

import com.studyolle.modules.zone.Zone;
import lombok.Data;

@Data
public class ZoneForm {

    //TODO Seoul(서울)/NONE 이런식으로 들어옴
    private String zoneName;


    public String getCityName() {
        return zoneName.substring(0, zoneName.indexOf("("));
    }

    public String getProvinceName() {
        return zoneName.substring(zoneName.indexOf("/") + 1);
    }

    public String getLocalNameOfCity() {
        return zoneName.substring(zoneName.indexOf("(") + 1, zoneName.indexOf(")"));
    }

    public Zone getZone() {
        return Zone.builder().city(this.getCityName())
                .localNameOfCity(this.getLocalNameOfCity())
                .province(this.getProvinceName()).build();
    }

}
