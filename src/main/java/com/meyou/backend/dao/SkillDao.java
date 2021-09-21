package com.meyou.backend.dao;

import com.meyou.backend.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillDao extends JpaRepository<Skill,Integer> {
}
