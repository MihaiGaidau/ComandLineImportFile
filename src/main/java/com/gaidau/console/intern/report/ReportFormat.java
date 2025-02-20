package com.gaidau.console.intern.report;

public enum ReportFormat {
    EXCEL("xlsx"),
    PDF("pdf");

    private final String value;

    ReportFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
