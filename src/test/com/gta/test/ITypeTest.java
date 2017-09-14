package com.gta.test;

/**
 * Desc: TypeTest
 * User: jiangningning
 * Date: 2017/9/12
 * Time: 16:11
 */
public interface ITypeTest<T, K> {

    T getById(int id);

    T getByK(K k);
}
