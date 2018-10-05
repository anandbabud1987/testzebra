package com.zebra.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.zebra.entity.HurricaneStatistics;
import com.zebra.entity.MustardStatistics;

public interface HurricaneStatisticsRepository extends JpaRepository<HurricaneStatistics, Long> {



}
