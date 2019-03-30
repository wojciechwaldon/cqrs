package com.wojciechwaldon.cqrs.application.query.model;

import com.wojciechwaldon.cqrs.api.query.QueryHandler;

public class TestReadQueryHandler implements QueryHandler<TestReadQuery, TestReadQueryView> {

    public TestReadQueryView handle(TestReadQuery query) {
        return TestReadQueryView.of(query.getMessageToRead());
    }
}
