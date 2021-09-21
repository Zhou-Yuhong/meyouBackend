package com.meyou.backend.dao;

import com.meyou.backend.entity.MatchTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchTagDao extends JpaRepository<MatchTag,Integer> {
}
