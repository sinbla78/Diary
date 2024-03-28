package com.example.sod.domain.feed.service;

import com.example.sod.domain.feed.controller.dto.response.GetFeedDetailsResponse;
import com.example.sod.domain.feed.domain.Feed;
import com.example.sod.domain.feed.domain.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetFeedDetailsService {
    private final FeedRepository feedRepository;

    public GetFeedDetailsResponse  getDetails(Long id) {
        Feed feed = feedRepository.findByFeedId(id);

        return new GetFeedDetailsResponse(
                feed.getTitle(),
                feed.getContent(),
                feed.getWeather(),
                feed.getDay(),
                feed.getName()
        );
    }
}
