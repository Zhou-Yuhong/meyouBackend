package com.meyou.backend.dao;

import com.meyou.backend.entity.Matched;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchedDao extends JpaRepository<Matched,Integer> {
}
