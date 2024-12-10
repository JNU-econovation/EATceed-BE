package com.gaebaljip.exceed.adapter.out.jpa.announce;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaebaljip.exceed.application.domain.announce.AnnounceEntity;

public interface AnnounceRepository extends JpaRepository<AnnounceEntity, Long> {}
