package com.jobposting;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jobposting.entity.JobPosting;
import com.jobposting.repo.JobPostingRepo;
import com.jobposting.service.JobPostingService;

@SpringBootTest
class JobPostingApiApplicationTests {

	@Autowired
	private JobPostingService jobPostingService;

	@Autowired
	private JobPostingRepo jobPostingRepo;

	@Test
	public void testCreateJobPosting() {
		JobPosting jobPosting = new JobPosting();
		when(jobPostingRepo.save(any(JobPosting.class))).thenReturn(jobPosting);
		JobPosting createdJobPosting = jobPostingService.createJobPosting(jobPosting);
		assertNotNull(createdJobPosting);
	}

}
