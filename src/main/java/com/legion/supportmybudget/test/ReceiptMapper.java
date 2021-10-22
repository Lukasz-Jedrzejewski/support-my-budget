package com.legion.supportmybudget.test;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReceiptMapper {

    @Insert("INSERT INTO receipts (id, creation_date, update_date, removed, sum) VALUES(#{id, javaType=java.util.UUID, jdbcType=OTHER, typeHandler=com.legion.supportmybudget.test.UuidTypeHandler}, #{creation_date}, #{update_date}, #{removed}, #{sum})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Receipt receipt);

    @Select("SELECT id, sum FROM receipts")
    List<Receipt> findAll();
}
