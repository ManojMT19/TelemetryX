package com.telemetryx.api.repository;

import com.telemetryx.api.entity.TelemetryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface TelemetryDataRepository extends JpaRepository<TelemetryData, Long> , JpaSpecificationExecutor<TelemetryData>
{

}
