package com.gaebaljip.exceed.adapter.out.jpa.announce;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gaebaljip.exceed.application.domain.announce.AnnounceEntity;
import com.gaebaljip.exceed.application.port.out.announce.AnnouncePort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AnnouncePersistenceAdapter implements AnnouncePort {
    private final AnnounceRepository announceRepository;

    @Override
    public List<AnnounceEntity> findAll() {
        return announceRepository.findAll();
    }

    @Override
    public AnnounceEntity command(AnnounceEntity announceEntity) {
        return announceRepository.save(announceEntity);
    }
}
