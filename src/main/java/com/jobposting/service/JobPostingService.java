package com.jobposting.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobposting.entity.JobPosting;
import com.jobposting.repo.JobPostingRepo;

@Service
public class JobPostingService {

	@Autowired
	private JobPostingRepo jobPostingRepo;

	public JobPosting createJobPosting(JobPosting jobPosting) {
		return jobPostingRepo.save(jobPosting);
	}

	public JobPosting getJobPostingById(Long id) {
		return jobPostingRepo.findById(id).orElseThrow();
	}

	public List<JobPosting> getJobPostingAll() {
		return jobPostingRepo.findAll();
	}

	public JobPosting updateJobPosting(Long id, JobPosting jobPosting) {
		JobPosting existingJobPosting = getJobPostingById(id);
		// Update fields
		return jobPostingRepo.save(existingJobPosting);
	}

	public void deleteJobPosting(Long id) {
		jobPostingRepo.deleteById(id);
	}

	public List<JobPosting> searchJobPosting(String keyword, String location, String requiredSkills) {
		// Implement search logic
		if (keyword == null && location == null && requiredSkills == null) {
			return jobPostingRepo.findAll(); // If no search parameters, return all job postings
		}

		// Example search logic (customize based on your requirements)
		return jobPostingRepo.findAll().stream().filter(
				job -> (keyword == null || job.getTitle().contains(keyword) || job.getDescription().contains(keyword))
						&& (location == null || job.getLocation().equalsIgnoreCase(location))
						&& (requiredSkills == null || job.getRequiredSkills().stream()
								.anyMatch(skill -> skill.equalsIgnoreCase(requiredSkills))))
				.collect(Collectors.toList());

	}

}
