package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}