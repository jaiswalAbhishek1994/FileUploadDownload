package com.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

}
