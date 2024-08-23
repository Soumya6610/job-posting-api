package com.jobposting.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobposting.entity.JobPosting;

public interface JobPostingRepo extends JpaRepository<JobPosting, Long> {
	
}
