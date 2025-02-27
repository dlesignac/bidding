package fr.agregio.bidding.server.tool;

import java.util.List;

public interface TwoWayMapper<T, U> {

    T from(U u);

    U to(T t);

    default List<T> fromAll(List<U> us) {
        return us.stream()
                .map(this::from)
                .toList();
    }

    default List<U> toAll(List<T> ts) {
        return ts.stream()
                .map(this::to)
                .toList();
    }

}
