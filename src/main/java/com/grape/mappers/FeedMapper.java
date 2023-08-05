package com.grape.mappers;


import com.grape.dto.FeedDTO;
import com.grape.model.Feed;
import com.grape.request.FeedRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FeedMapper {
    FeedDTO mapDTO(Feed feed);
    List<FeedDTO> mapDTOs(List<Feed> accounts);

    Feed map(FeedRequest request);

}
