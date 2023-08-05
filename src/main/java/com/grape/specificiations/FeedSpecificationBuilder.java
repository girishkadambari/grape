package com.grape.specificiations;

import com.grape.model.Feed;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

public class FeedSpecificationBuilder extends BaseSpecificationsBuilder {

    public FeedSpecificationBuilder() {
        super(new ArrayList<>());
    }

    @Override
    public Specification<Feed> build() {
        if (params.size() == 0) {
            return null;
        }

        Specification result = new FeedSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = Specification.where(result).and(new FeedSpecification(params.get(i)));
        }
        return result;
    }
}

