package com.gaebaljip.exceed.application.service.announce;

import org.springframework.stereotype.Component;

import com.gaebaljip.exceed.adapter.in.announce.request.CreateAnnounceRequest;
import com.gaebaljip.exceed.application.domain.announce.AnnounceEntity;
import com.gaebaljip.exceed.application.port.in.announce.CreateAnnounceUseCase;
import com.gaebaljip.exceed.application.port.out.announce.AnnouncePort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateAnnounceService implements CreateAnnounceUseCase {
    private final AnnouncePort announcePort;

    @Override
    public void execute(CreateAnnounceRequest request) {
        AnnounceEntity announceEntity =
                AnnounceEntity.builder().title(request.title()).content(request.content()).build();
        announcePort.command(announceEntity);
    }
}
