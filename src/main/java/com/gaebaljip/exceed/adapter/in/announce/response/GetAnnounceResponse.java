package com.gaebaljip.exceed.adapter.in.announce.response;

import java.util.List;

import com.gaebaljip.exceed.common.dto.AnnounceDTO;

public record GetAnnounceResponse(List<AnnounceDTO> announces) {
    public static GetAnnounceResponse of(List<AnnounceDTO> announces) {
        return new GetAnnounceResponse(announces);
    }
}
