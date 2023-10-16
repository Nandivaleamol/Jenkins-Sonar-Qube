package com.checkerslab.electricdevice.service.impl;

import com.checkerslab.electricdevice.entities.ElectricDevice;
import com.checkerslab.electricdevice.repository.ElectricDeviceRepository;
import com.checkerslab.electricdevice.service.ElectricDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ElectricDeviceServiceImpl implements ElectricDeviceService {

    @Autowired
    private ElectricDeviceRepository electricDeviceRepository;

    private final Logger logger = LoggerFactory.getLogger(ElectricDeviceServiceImpl.class);

    @Override
    public ElectricDevice addNewElectricDevice(ElectricDevice electricDevice) {
        electricDevice.setCreationDateTime(LocalDateTime.now());
        return electricDeviceRepository.save(electricDevice);
    }

    @Override
    public List<ElectricDevice> getAllElectricDeviceByLast10MinuteEntriesByDeviceId(String deviceId) {

        var minusMinutes = LocalDateTime.now().minusMinutes(10);
        logger.info("MINUS 10 MINUTE {}",minusMinutes);

        return this.electricDeviceRepository
                .findAllByDeviceIdAndCreationDateTimeAfter(deviceId, minusMinutes);
    }
}
