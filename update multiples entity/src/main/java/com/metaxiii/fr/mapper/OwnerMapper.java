package com.metaxiii.fr.mapper;

import com.metaxiii.fr.domain.Owner;
import com.metaxiii.fr.entity.OwnerEntity;
import com.metaxiii.fr.DTO.OwnerEntityProjectionDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface OwnerMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toEntity(Owner save, @MappingTarget OwnerEntity entity);

    Owner toDomain(OwnerEntityProjectionDTO projectionDTO);
}
