package org.example.thi2.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findall();
    Optional<T> findById(Long id);
    T save(T t);
    void remove(Long id);
}
