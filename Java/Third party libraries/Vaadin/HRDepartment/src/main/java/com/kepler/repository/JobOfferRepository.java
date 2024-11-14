package com.kepler.repository;

import com.kepler.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {
}
