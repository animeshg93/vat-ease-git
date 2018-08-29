package com.aexp.model;

import com.aexp.parser.ParserResponse;
import com.google.protobuf.ByteString;

public interface Parser {
    ParserResponse parse(ByteString imgBytes) throws Exception;
}
