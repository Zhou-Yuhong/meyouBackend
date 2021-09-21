package com.meyou.backend.dao;

import com.meyou.backend.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDao extends JpaRepository<Team,Integer> {
}
