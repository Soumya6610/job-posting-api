package com.jobposting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobposting.entity.JobPosting;
import com.jobposting.service.JobPostingService;

@RestController
@RequestMapping("/api/v1/jobpostings/")
public class JobPostingController {

	@Autowired
	private JobPostingService jobPostingService;

	@PostMapping("/create")
	public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPosting jobPosting) {
		JobPosting createdJobPosting = jobPostingService.createJobPosting(jobPosting);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdJobPosting);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<JobPosting> getJobPostingById(@PathVariable Long id) {
		JobPosting jobPosting = jobPostingService.getJobPostingById(id);
		return ResponseEntity.ok(jobPosting);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<JobPosting>> getJobPostingAll() {
		return ResponseEntity.ok(this.jobPostingService.getJobPostingAll());
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<JobPosting> updateJobPosting(@PathVariable Long id, @RequestBody JobPosting jobPosting) {
		JobPosting updatedJobPosting = jobPostingService.updateJobPosting(id, jobPosting);
		return ResponseEntity.ok(updatedJobPosting);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteJobPosting(@PathVariable Long id) {
		jobPostingService.deleteJobPosting(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/search")
	public ResponseEntity<List<JobPosting>> searchJobPostings(@RequestParam(required = false) String keyword,
			@RequestParam(required = false) String location, @RequestParam(required = false) String requiredSkills) {
		List<JobPosting> jobPostings = jobPostingService.searchJobPosting(keyword, location, requiredSkills);
		return ResponseEntity.ok(jobPostings);
	}
}
