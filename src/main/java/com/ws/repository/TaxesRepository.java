package com.ws.repository;

import com.ws.entity.TaxesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxesRepository extends JpaRepository<TaxesEntity,Long> {
}
