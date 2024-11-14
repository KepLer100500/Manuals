package com.kepler.service;

import com.kepler.model.JobOffer;
import com.kepler.repository.JobOfferRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class JobOfferService {
    private final JobOfferRepository jobOfferRepository;
    private final NotificationService notificationService;

    public JobOfferService(JobOfferRepository jobOfferRepository, NotificationService notificationService) {
        this.jobOfferRepository = jobOfferRepository;
        this.notificationService = notificationService;
    }

    @Transactional
    public List<JobOffer> findAll() {
        return jobOfferRepository.findAll();
    }

    @Transactional
    public JobOffer save(JobOffer jobOffer) {
        notificationService.notifyAllClients();
        return jobOfferRepository.save(jobOffer);
    }

    @Transactional
    public void delete(JobOffer jobOffer) {
        notificationService.notifyAllClients();
        jobOfferRepository.delete(jobOffer);
    }
}
