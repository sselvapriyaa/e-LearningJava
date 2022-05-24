package com.training.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springboot.model.Course;


public interface CourseRepository extends JpaRepository<Course, Integer> {
}

