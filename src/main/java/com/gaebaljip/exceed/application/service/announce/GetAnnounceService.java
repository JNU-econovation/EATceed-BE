package com.gaebaljip.exceed.application.service.announce;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gaebaljip.exceed.adapter.in.announce.response.GetAnnounceResponse;
import com.gaebaljip.exceed.application.port.in.announce.GetAnnounceQuery;
import com.gaebaljip.exceed.application.port.out.announce.AnnouncePort;
import com.gaebaljip.exceed.common.dto.AnnounceDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetAnnounceService implements GetAnnounceQuery {
    private final AnnouncePort announcePort;

    @Override
    public GetAnnounceResponse execute() {
        List<AnnounceDTO> announceDTOS =
                announcePort.findAll().stream()
                        .map(
                                announceEntity ->
                                        AnnounceDTO.of(
                                                announceEntity.getId(),
                                                announceEntity.getTitle(),
                                                announceEntity.getContent(),
                                                announceEntity.getCreatedDate()))
                        .toList();
        return GetAnnounceResponse.of(announceDTOS);
    }
}
