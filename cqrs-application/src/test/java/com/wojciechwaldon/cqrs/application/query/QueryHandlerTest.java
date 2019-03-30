package com.wojciechwaldon.cqrs.application.query;

import com.wojciechwaldon.cqrs.api.query.QueryExecutor;
import com.wojciechwaldon.cqrs.application.configuration.TestCommandConfiguration;
import com.wojciechwaldon.cqrs.application.query.model.TestReadQuery;
import com.wojciechwaldon.cqrs.application.query.model.TestReadQueryView;
import com.wojciechwaldon.cqrs.application.query.model.TestReadWithExceptionQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestCommandConfiguration.class)
public class QueryHandlerTest {

    @Autowired
    private QueryExecutor queryExecutor;

    @Test
    public void shouldExecuteQuery() throws Exception {
        //given
        String messageToRead = "Message to read";
        TestReadQuery query = TestReadQuery.of(messageToRead);

        //when
        TestReadQueryView view = queryExecutor.execute(query);

        //then
        assertEquals(messageToRead, view.getReadMessage());
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionDuringExecutingQuery() throws Exception {
        //given
        String messageToRead = "Message to read";
        TestReadWithExceptionQuery query = TestReadWithExceptionQuery.of(messageToRead);

        //when
        queryExecutor.execute(query);
    }
}
