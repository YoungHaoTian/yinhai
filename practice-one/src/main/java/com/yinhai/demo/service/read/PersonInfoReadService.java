package com.yinhai.demo.service.read;

import com.yinhai.demo.vo.PsnInfoBInfoVo;
import com.yinhai.demo.vo.PsnInfoBQueryVo;
import com.yinhai.ta404.core.restservice.requestbean.PageParam;
import com.yinhai.ta404.core.restservice.resultbean.Page;

import java.util.List;


/**
 * 人员基本信息(PsnInfoB)表服务接口
 *
 * @author default
 * @since 2020-08-17 22:45:18
 */
public interface PersonInfoReadService {

    /**
     * 通过ID查询单条数据
     *
     * @param psnNo 主键
     * @return 实例对象
     */
    PsnInfoBInfoVo queryPsnInfoBInfoById(String psnNo);

    /**
     * 根据查询条件查询数据
     *
     * @param psnInfoBQueryVo
     */
    List<PsnInfoBInfoVo> queryPsnInfoBInfoList(PsnInfoBQueryVo psnInfoBQueryVo);

    /**
     * 根据查询条件分页查询数据
     *
     * @param psnInfoBQueryVo
     * @param pageParam
     * @param need            是否需要查询表中记录的总数
     * @param vague           是否需要进行模糊查询
     */
    Page<PsnInfoBInfoVo> queryPsnInfoBInfoPage(PsnInfoBQueryVo psnInfoBQueryVo, PageParam pageParam, Boolean need, Boolean vague);

    /**
     * 根据参数值返回包含该参数值的所有主键
     *
     * @param psnNo
     * @return
     */
    List<String> queryPsnNoList(String psnNo);

    /**
     * 根据查询条件模糊查询数据并进行分页
     *
     * @param psnInfoBQueryVo
     * @param pageParam
     * @return
     */
    Page<PsnInfoBInfoVo> vagueQueryPsnInfoBInfoPage(PsnInfoBQueryVo psnInfoBQueryVo, PageParam pageParam);

    /**
     * 根据查询条件统计数量
     *
     * @param psnInfoBQueryVo
     * @return
     */
    Long countNumber(PsnInfoBQueryVo psnInfoBQueryVo);
}