package com.online.market.http.validation;

/**
 * Created by Alexander on 04.06.2017.
 */
public interface Validator<T> {
    T validate(T value);
}
