package com.missiongroup.starring.core.vehicleData;

import com.missiongroup.starring.modular.vhis.config.domain.FaultConfig;

import java.util.List;

public class FaultDataFactory extends DatatFactory{
    private static void createFaultData(){
        Long mpu_cTrainNumber = getValue("port0x101","MPU_CTrainNumber");
        List<FaultConfig> faultConfigs = iCaches.get("CONSTANT", "faultConfigs");

    }


    /**
     * 门的故障
     */
    private static void doorFault(){
    }

}
