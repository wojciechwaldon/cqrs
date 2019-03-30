package com.wojciechwaldon.cqrs.api.query;

public interface QueryHandler<S extends Query, T extends QueryView> {

    T handle(S query) throws Exception;
}
