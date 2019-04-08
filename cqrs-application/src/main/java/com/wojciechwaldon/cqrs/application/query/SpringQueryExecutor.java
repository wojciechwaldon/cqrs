package com.wojciechwaldon.cqrs.application.query;

import com.wojciechwaldon.cqrs.api.query.Query;
import com.wojciechwaldon.cqrs.api.query.QueryExecutor;
import com.wojciechwaldon.cqrs.api.query.QueryHandler;
import com.wojciechwaldon.cqrs.api.query.QueryView;
import com.wojciechwaldon.cqrs.application.handlers.QueryHandlersProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SpringQueryExecutor implements QueryExecutor {

    private QueryHandlersProvider queryHandlersProvider;

    @SuppressWarnings("unchecked")
    public QueryView execute(Query query) throws Exception {
        QueryHandler<Query, QueryView> handler = queryHandlersProvider.getHandler(query);
        return handler.handle(query);
    }
}

