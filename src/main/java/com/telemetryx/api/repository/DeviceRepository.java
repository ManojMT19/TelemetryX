package com.telemetryx.api.repository;

import com.telemetryx.api.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device , Long>
{
    java.util.List<Device> findAllByOrderByIdAsc();
}
