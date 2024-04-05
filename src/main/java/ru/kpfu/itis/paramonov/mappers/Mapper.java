package ru.kpfu.itis.paramonov.mappers;

public interface Mapper<M, D> {
    D map(M model);
}
