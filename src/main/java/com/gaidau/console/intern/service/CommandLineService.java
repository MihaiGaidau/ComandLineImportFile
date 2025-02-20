package com.gaidau.console.intern.service;

import com.gaidau.console.intern.domain.dto.RootDTO;

public interface CommandLineService {

    public RootDTO run(Object... args);

    public LineCommand getLineCommand();
}
