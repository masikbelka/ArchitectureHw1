package com.epam.cdp.architecture.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<SOURCE, TARGET> {
    public List<TARGET> convertAll(List<SOURCE> sources) {
        List<TARGET> converted = new ArrayList<>();
        if (sources != null) {
            converted.addAll(
                    sources.stream()
                            .map(this::convert).collect(Collectors.toList()));
        }
        return converted;
    }

    public abstract TARGET convert(SOURCE source);
}
