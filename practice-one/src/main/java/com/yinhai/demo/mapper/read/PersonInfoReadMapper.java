package com.yinhai.demo.mapper.read;

import com.yinhai.demo.vo.PsnInfoBInfoVo;
import com.yinhai.demo.vo.PsnInfoBQueryVo;
import com.yinhai.ta404.module.mybatis.mapper.Ta404SupportMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 人员基本信息(PsnInfoB)表数据库访问层
*
* @author default
* @since 2020-08-17 22:45:18
*/
public interface PersonInfoReadMapper extends Ta404SupportMapper{

    /**
    * 通过ID查询单条数据
    *
    * @param psnNo 主键
    * @return 实例对象
    */
    PsnInfoBInfoVo queryById(String psnNo);

    /**
    * 查询指定行数据
    *
    * @return 对象列表
    */
    List<PsnInfoBInfoVo> queryList(PsnInfoBQueryVo psnInfoBQueryVo);

    /**
     * 根据参数值返回包含该参数值的所有主键
     *
     * @param psnNo 主键
     * @return
     */
    List<String> queryPsnNoList(@Param("psnNo") String psnNo);

    /**
     * 模糊条件查询数据
     *
     * @param psnInfoBQueryVo
     * @return
     */
    List<PsnInfoBInfoVo> vagueQueryList(PsnInfoBQueryVo psnInfoBQueryVo);

    /**
     * 根据查询条件进行模糊查询统计数量
     *
     * @return
     */
    Long vagueCountNumber(PsnInfoBQueryVo psnInfoBQueryVo);

    /**
     * 根据查询条件统计数量
     *
     * @param psnInfoBQueryVo
     * @return
     */
    Long countNumber(PsnInfoBQueryVo psnInfoBQueryVo);


}