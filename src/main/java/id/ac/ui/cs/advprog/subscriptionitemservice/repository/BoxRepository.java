package id.ac.ui.cs.advprog.subscriptionitemservice.repository;

import id.ac.ui.cs.advprog.subscriptionitemservice.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {
}