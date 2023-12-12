package com.prism.mr.repository;

import com.prism.mr.model.PrimarySales;
import com.prism.mr.model.PrimarySalesProjection;
import com.prism.mr.model.SecondarySale;
import com.prism.mr.model.SecondarySaleProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "secondarySale", collectionResourceRel = "secondarySale", excerptProjection = SecondarySaleProjection.class)
public interface SecondarySaleRepository extends JpaRepository<SecondarySale,Long> {
}
