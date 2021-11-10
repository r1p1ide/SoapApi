package com.example.soapApi.logging;

import net.ttddyy.dsproxy.listener.logging.DefaultQueryLogEntryCreator;
import org.hibernate.engine.jdbc.internal.FormatStyle;
import org.hibernate.engine.jdbc.internal.Formatter;

public class PrettyHighLightQueryEntryCreator extends DefaultQueryLogEntryCreator {

    private final Formatter highlightFormatter = FormatStyle.HIGHLIGHT.getFormatter();
    private final Formatter basicFormatter = FormatStyle.HIGHLIGHT.getFormatter();

    @Override
    protected String formatQuery(String query) {
        return highlightFormatter.format(basicFormatter.format(query));
    }

}
