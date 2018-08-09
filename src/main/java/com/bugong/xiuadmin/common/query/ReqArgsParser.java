package com.bugong.xiuadmin.common.query;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReqArgsParser {

    public static ReqArgs parse(String args) {

        if (args.isEmpty()) {
            return new ReqArgs();
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readerFor(ReqArgs.class).readValue(args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
