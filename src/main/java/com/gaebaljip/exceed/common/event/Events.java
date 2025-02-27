package com.gaebaljip.exceed.common.event;

import org.springframework.context.ApplicationEventPublisher;

public class Events {
    private static final ThreadLocal<ApplicationEventPublisher> publisherLocal =
            new ThreadLocal<>();

    public static void raise(DomainEvent event) {
        if (event == null) return;

        if (publisherLocal.get() != null) {
            publisherLocal.get().publishEvent(event);
        }
    }

    public static void raise(InfraEvent event) {
        if (event == null) return;

        if (publisherLocal.get() != null) {
            publisherLocal.get().publishEvent(event);
        }
    }

    public static void setPublisher(ApplicationEventPublisher publisher) {
        publisherLocal.set(publisher);
    }

    public static void reset() {
        publisherLocal.remove();
    }
}
