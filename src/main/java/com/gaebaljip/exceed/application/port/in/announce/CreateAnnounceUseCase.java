package com.gaebaljip.exceed.application.port.in.announce;

import com.gaebaljip.exceed.adapter.in.announce.request.CreateAnnounceRequest;

public interface CreateAnnounceUseCase {
    void execute(CreateAnnounceRequest request);
}
