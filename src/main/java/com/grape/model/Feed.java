package com.grape.model;

import com.grape.model.enums.FeedStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "feeds")
@Getter
@Setter
@ToString
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "label")
    private String label;

    @Column(name = "content")
    private String content;

    @Column(name = "insert_link_text")
    private String insertLinkText;

    @Column(name = "insert_link_url")
    private String insertLinkURL;

    @Column(name = "status_enum")
    @Enumerated(EnumType.STRING)
    private FeedStatus status;

    @Column(name = "from_date")
    private Timestamp fromDate;

    @Column(name = "expire_date")
    private Timestamp expireDate;

    @Column(name = "language")
    private String language;

    @Column(name = "segment_filters", columnDefinition = "TEXT")
    private String segmentFilters;

    @Column(name = "in_app")
    private Boolean inApp;

    @Column(name = "standalone")
    private Boolean standalone;

    @Column(name = "push")
    private Boolean push;

    @Column(name = "email")
    private Boolean email;

    @Column(name = "topbar")
    private Boolean topbar;

    @Column(name = "popup")
    private Boolean popup;

    @Column(name = "snippet")
    private Boolean snippet;

    @Column(name = "tooltip")
    private Boolean tooltip;

    @Column(name = "enable_comments")
    private Boolean enableComments;

    @Column(name = "enable_social_media")
    private Boolean enableSocialMedia;

    @Column(name = "enable_reaction")
    private Boolean enableReaction;

    @Column(name = "pin_to_top")
    private Boolean pinToTop;

    @Column(name = "open_link_in_new_tab")
    private Boolean openLinkInNewTab;
}
