package com.training.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springboot.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
}

