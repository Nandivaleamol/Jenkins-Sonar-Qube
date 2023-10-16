package com.checkerslab.electricdevice.controller;

import com.checkerslab.electricdevice.entities.ElectricDevice;
import com.checkerslab.electricdevice.service.ElectricDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cil/electric_devices")
public class ElectricDeviceRestController {

    @Autowired
    private ElectricDeviceService electricDeviceService;

    @PostMapping(value = "/add")
    public ResponseEntity<?> addNewElectricDevice(@RequestBody ElectricDevice electricDevice){
        if (electricDevice.getPaymentId()==null || electricDevice.getPaymentId().isBlank()){
            return ResponseEntity.badRequest().body("Please provide paymentId.");
        }
        var device = this.electricDeviceService.addNewElectricDevice(electricDevice);

        if (device!=null){
            return ResponseEntity.ok("New Electric Device added successfully!");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong! Please try again or contact your service provider!");
        }
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<List<ElectricDevice>> getAllElectricDevicesById(@RequestParam("deviceId") String deviceId){

        if (deviceId==null) {
            throw new IllegalArgumentException("Please provide device ID.");
        }
        var electricDeviceList = this.electricDeviceService.getAllElectricDeviceByLast10MinuteEntriesByDeviceId(deviceId.strip());
        return ResponseEntity.ok(electricDeviceList);
    }
}
