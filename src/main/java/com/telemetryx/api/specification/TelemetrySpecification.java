package com.telemetryx.api.specification;

import com.telemetryx.api.entity.TelemetryData;
import org.springframework.data.jpa.domain.Specification;

public class TelemetrySpecification
{
    public static Specification<TelemetryData> hasDeviceId(Long deviceId)
    {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("device").get("id") , deviceId);
    }

    public static Specification<TelemetryData> isHazardous()
    {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isTrue(root.get("hazardous"));
    }

    public static Specification<TelemetryData> minSpeed(Double speed)
    {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("speed"),speed);
    }

}
