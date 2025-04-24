package com.orlovandrei.hotel.mapper;

import com.orlovandrei.hotel.entity.maintenance.Maintenance;
import com.orlovandrei.hotel.dto.maintenance.MaintenanceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaintenanceMapper extends Mappable<Maintenance, MaintenanceDto> {
}
