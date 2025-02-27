package fr.agregio.bidding.server.tool;

import java.util.List;

public interface OneWayMapper<T, U> {

    U map(T t);

    default List<U> mapAll(List<T> ts) {
        return ts.stream()
                .map(this::map)
                .toList();
    }

}
