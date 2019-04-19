package com.mosdev.restapi.repos;

import com.mosdev.restapi.domain.Ads;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdsRepo extends JpaRepository<Ads, Long> {
}
