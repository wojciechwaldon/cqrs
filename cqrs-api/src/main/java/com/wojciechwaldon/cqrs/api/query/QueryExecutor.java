package com.wojciechwaldon.cqrs.api.query;

public interface QueryExecutor {

    <T extends QueryView> T execute(Query<T> query) throws Exception;
}
