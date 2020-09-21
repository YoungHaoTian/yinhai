package com.yinhai.demo.mapper.write;

import com.yinhai.demo.entity.PsnInfoB;

/**
* 人员基本信息(PsnInfoB)表数据库访问层
*
* @author default
* @since 2020-08-17 22:45:18
*/
public interface PersonInfoWriteMapper {
    /**
    * 新增数据
    *
    * @param psnInfoB 实例对象
    * @return 影响行数
    */
    int insert(PsnInfoB psnInfoB);

    /**
    * 修改数据
    *
    * @param psnInfoB 实例对象
    * @return 影响行数
    */
    int update(PsnInfoB psnInfoB);

    /**
    * 通过主键物理删除数据
    *
    * @param psnNo 主键
    * @return 影响行数
    */
    int deleteById(String psnNo);

    /**
    * 通过主键逻辑删除数据
    *
    * @param psnNo 主键
    * @return 影响行数
    */
    int updateToDestroyById(String psnNo);

}