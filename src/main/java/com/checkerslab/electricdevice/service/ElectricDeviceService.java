package com.checkerslab.electricdevice.service;

import com.checkerslab.electricdevice.entities.ElectricDevice;

import java.util.List;

public interface ElectricDeviceService {

    ElectricDevice addNewElectricDevice(ElectricDevice electricDevice);

    List<ElectricDevice> getAllElectricDeviceByLast10MinuteEntriesByDeviceId(String deviceId);
}
