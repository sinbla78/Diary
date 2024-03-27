package com.example.sod.domain.feed.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GetFeedDetailsResponse {
    private String title;
    private String content;
    private String weather;
    private String day;
    private String name;
}
