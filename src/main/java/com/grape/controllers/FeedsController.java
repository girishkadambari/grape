package com.grape.controllers;

import com.grape.dto.FeedDTO;
import com.grape.mappers.FeedMapper;
import com.grape.model.Feed;
import com.grape.request.FeedRequest;
import com.grape.services.FeedService;
import com.grape.specificiations.FeedSpecificationBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/feeds")
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FeedsController {

    private final FeedService feedService;
    private final FeedMapper feedMapper;

    @GetMapping
    public Page<FeedDTO> index(FeedSpecificationBuilder builder, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Specification<Feed> spec = builder.build();
        Page<Feed> feeds = feedService.findAll(spec, pageable);
        List<FeedDTO> feedDTOS = feedMapper.mapDTOs(feeds.getContent());
        return new PageImpl<>(feedDTOS, pageable, feeds.getTotalElements());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FeedDTO create(@RequestBody FeedRequest request) throws Exception {
        log.info("Post request /feeds/" + request);
        Feed feed = feedMapper.map(request);
        feed = feedService.save(feed);
        return feedMapper.mapDTO(feed);
    }

}
