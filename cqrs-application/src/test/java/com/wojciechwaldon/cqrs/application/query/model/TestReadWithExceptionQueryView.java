package com.wojciechwaldon.cqrs.application.query.model;

import com.wojciechwaldon.cqrs.api.query.QueryView;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class TestReadWithExceptionQueryView implements QueryView {

    private String readMessage;
}
