package com.metaxiii.fr.mapstruct.repository;

import com.metaxiii.fr.mapstruct.entity.UtilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilityRepository extends JpaRepository<UtilityEntity, Long> {}
