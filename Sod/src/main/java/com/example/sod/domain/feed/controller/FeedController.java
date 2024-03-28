package com.example.sod.domain.feed.controller;

import com.example.sod.domain.feed.controller.dto.request.NoticeFeedRequest;
import com.example.sod.domain.feed.controller.dto.request.UpdateFeedRequest;
import com.example.sod.domain.feed.controller.dto.response.GetFeedDetailsResponse;
import com.example.sod.domain.feed.service.DeleteFeedService;
import com.example.sod.domain.feed.service.GetFeedDetailsService;
import com.example.sod.domain.feed.service.NoticeFeedService;
import com.example.sod.domain.feed.service.UpdateFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feed")
@RestController
public class FeedController {

    private final NoticeFeedService noticeFeedService;
    private final DeleteFeedService deleteFeedService;
    private final UpdateFeedService updateFeedService;
    private final GetFeedDetailsService getFeedDetailsService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void noticeFeed(@RequestBody @Valid NoticeFeedRequest noticeFeedRequest) {
        noticeFeedService.execute(noticeFeedRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") Long feedId) {
        deleteFeedService.execute(feedId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{feed-id}")
    public void updateFeed(@PathVariable("feed-id") Long feedId, @RequestBody @Valid UpdateFeedRequest updateFeedRequest) {
        updateFeedService.execute(feedId, updateFeedRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/details/{id}")
    public GetFeedDetailsResponse getDetails(@PathVariable("id") Long id) {
        return getFeedDetailsService.getDetails(id);
    }
}
