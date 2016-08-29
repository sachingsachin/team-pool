package com.prismoskills.metrics;

import com.codahale.metrics.JvmAttributeGaugeSet;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jvm.FileDescriptorRatioGauge;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;
import com.codahale.metrics.servlets.MetricsServlet;
import com.prismoskills.util.Globals;

public class MyMetricsServletContextListener extends MetricsServlet.ContextListener {

    static {
        Globals.metrics.register("jvm-attribs", new JvmAttributeGaugeSet());
        Globals.metrics.register("jvm-gc", new GarbageCollectorMetricSet());
        Globals.metrics.register("jvm-memory", new MemoryUsageGaugeSet());
        Globals.metrics.register("jvm-thread-states", new ThreadStatesGaugeSet());
        Globals.metrics.register("jvm-fd-usage", new FileDescriptorRatioGauge());
    }

    @Override
    protected MetricRegistry getMetricRegistry() {
        return Globals.metrics;
    }
}
