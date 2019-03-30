package com.wojciechwaldon.cqrs.application.query.model;

import com.wojciechwaldon.cqrs.api.query.QueryHandler;

public class TestReadWithExceptionQueryHandler implements QueryHandler<TestReadWithExceptionQuery, TestReadWithExceptionQueryView> {

    public TestReadWithExceptionQueryView handle(TestReadWithExceptionQuery query) throws Exception {
        throw new Exception("TestReadWithExceptionQueryHandler successful");
    }
}
