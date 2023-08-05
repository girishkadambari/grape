package com.grape.services;

import com.grape.model.Feed;
import com.grape.repositories.FeedRepository;
import com.grape.request.FeedRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor(onConstructor = @__({@Autowired, @Lazy}))
public class FeedService {

    private final FeedRepository feedRepository;

    public Page<Feed> findAll(Specification<Feed> specification, Pageable pageable) {
        return feedRepository.findAll(specification, pageable);
    }

    public Feed save(Feed feed){
        return  feedRepository.save(feed);
    }

}
