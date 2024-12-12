package com.gaebaljip.exceed.application.port.out.announce;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gaebaljip.exceed.application.domain.announce.AnnounceEntity;

@Component
public interface AnnouncePort {
    List<AnnounceEntity> findAll();

    AnnounceEntity command(AnnounceEntity announceEntity);
}
