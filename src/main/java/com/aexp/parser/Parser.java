package com.aexp.parser;

import com.google.protobuf.ByteString;

public interface Parser {
    ParserResponse parse(ByteString imgBytes) throws Exception;
}
