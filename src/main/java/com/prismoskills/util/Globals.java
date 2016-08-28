package com.prismoskills.util;

import com.codahale.metrics.MetricRegistry;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Globals {

    public static ObjectMapper         mapper    = new ObjectMapper();
    static {
        mapper.setSerializationInclusion(Include.NON_NULL);
        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static final MetricRegistry metrics   = new MetricRegistry();
}
