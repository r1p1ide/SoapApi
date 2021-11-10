package com.example.soapApi.logging;

import net.ttddyy.dsproxy.listener.logging.AbstractQueryLoggingListener;
import net.ttddyy.dsproxy.listener.logging.DefaultQueryLogEntryCreator;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class ConnectionLoggingListener extends AbstractQueryLoggingListener {

    private final static Logger LOG = Logger.getLogger(ConnectionLoggingListener.class.getCanonicalName());
    private final ApplicationContext ctx;
    private final DefaultQueryLogEntryCreator creator;

    public ConnectionLoggingListener(ApplicationContext ctx, DefaultQueryLogEntryCreator creator) {

        this.ctx = ctx;
        this.creator = creator;
        this.loggingCondition = () -> true;
        creator.setMultiline(true);
        setQueryLogEntryCreator(creator);
    }

    @Override
    protected void writeLog(String s) {
        LOG.log(INFO, s);
    }
}
