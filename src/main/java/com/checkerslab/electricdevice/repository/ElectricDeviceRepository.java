package com.checkerslab.electricdevice.repository;

import com.checkerslab.electricdevice.entities.ElectricDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ElectricDeviceRepository extends JpaRepository<ElectricDevice, Long> {

    List<ElectricDevice> findAllByDeviceIdAndCreationDateTimeAfter(
            String deviceId,
            LocalDateTime tenMinutesAgo
    );
}
