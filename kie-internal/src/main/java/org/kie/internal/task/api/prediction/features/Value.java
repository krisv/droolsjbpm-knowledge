package org.kie.internal.task.api.prediction.features;

public interface Value<T> {

    boolean compare(Value other);
    Value clone();
    T getData();
    String toString();
    int hashCode();
}
