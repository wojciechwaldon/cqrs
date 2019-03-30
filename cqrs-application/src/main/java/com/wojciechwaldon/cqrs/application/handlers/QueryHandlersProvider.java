package com.wojciechwaldon.cqrs.application.handlers;

import com.wojciechwaldon.cqrs.api.query.Query;
import com.wojciechwaldon.cqrs.api.query.QueryHandler;
import com.wojciechwaldon.cqrs.api.query.QueryView;

public interface QueryHandlersProvider {

    QueryHandler<Query, QueryView> getHandler(Query query);
}
