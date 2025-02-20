package com.gaidau.console.intern.report;

public interface IReport<T> {
    byte[] export(T object) throws Exception;

    ReportFormat getFormat();
}
