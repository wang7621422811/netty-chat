package com.nettychat.utils;

import tk.mybatis.mapper.common.Mapper;

public interface BaseMapper<T> extends Mapper<T> {

    @Override
    int insert(T t);

    @Override
    int insertSelective(T t);

    @Override
    T selectByPrimaryKey(Object o);

    @Override
    int updateByPrimaryKey(T t);

    @Override
    int updateByExample(T t, Object o);

    @Override
    int updateByExampleSelective(T t, Object o);

    @Override
    int updateByPrimaryKeySelective(T t);

    @Override
    int delete(T t);

    @Override
    int deleteByExample(Object o);

    @Override
    int deleteByPrimaryKey(Object o);
}
