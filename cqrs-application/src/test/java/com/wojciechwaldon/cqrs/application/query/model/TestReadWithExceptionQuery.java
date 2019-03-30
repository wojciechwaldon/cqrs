package com.wojciechwaldon.cqrs.application.query.model;

import com.wojciechwaldon.cqrs.api.query.Query;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class TestReadWithExceptionQuery implements Query<TestReadWithExceptionQueryView> {

    private String messageToRead;
}
