package com.gaebaljip.exceed.application.port.in.announce;

import org.springframework.stereotype.Component;

import com.gaebaljip.exceed.adapter.in.announce.response.GetAnnounceResponse;

@Component
public interface GetAnnounceQuery {
    GetAnnounceResponse execute();
}
