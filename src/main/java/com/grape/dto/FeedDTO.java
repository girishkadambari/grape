package com.grape.dto;

import com.grape.model.enums.FeedStatus;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class FeedDTO {
    private Long id;
    private String title;
    private String label;
    private String content;
    private String insertLinkText;
    private String insertLinkURL;
    private FeedStatus status;
    private Timestamp fromDate;
    private Timestamp expireDate;
    private String language;
    private String segmentFilters;
    private Boolean inApp;
    private Boolean standalone;
    private Boolean push;
    private Boolean email;
    private Boolean topbar;
    private Boolean popup;
    private Boolean snippet;
    private Boolean tooltip;
    private Boolean enableComments;
    private Boolean enableSocialMedia;
    private Boolean enableReaction;
    private Boolean pinToTop;
    private Boolean openLinkInNewTab;
}
