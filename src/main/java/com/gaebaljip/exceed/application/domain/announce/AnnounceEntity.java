package com.gaebaljip.exceed.application.domain.announce;

import javax.persistence.*;

import com.gaebaljip.exceed.common.BaseEntity;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = AnnounceEntity.ENTITY_PREFIX + "_TB")
@Builder()
public class AnnounceEntity extends BaseEntity {
    public static final String ENTITY_PREFIX = "ANNOUNCE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Column(name = ENTITY_PREFIX + "_CONTENT", nullable = false)
    private String content;

    @Column(name = ENTITY_PREFIX + "_TITLE", nullable = false)
    private String title;
}
