package com.yinhai.demo.service.read.impl;

import com.yinhai.demo.mapper.read.PersonInfoReadMapper;
import com.yinhai.demo.service.read.PersonInfoReadService;
import com.yinhai.demo.vo.PsnInfoBInfoVo;
import com.yinhai.demo.vo.PsnInfoBQueryVo;
import com.yinhai.ta404.core.restservice.requestbean.PageParam;
import com.yinhai.ta404.core.restservice.resultbean.Page;
import com.yinhai.ta404.core.transaction.annotation.NoTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 人员基本信息(PsnInfoB)表服务实现类
 *
 * @author default
 * @since 2020-08-17 22:45:18
 */
@Service
@NoTransactional
public class PersonInfoReadServiceImpl implements PersonInfoReadService {
    @Resource
    private PersonInfoReadMapper personInfoReadMapper;


    /**
     * 通过ID查询单条数据
     *
     * @param psnNo 主键
     * @return 实例对象
     */
    @Override
    public PsnInfoBInfoVo queryPsnInfoBInfoById(String psnNo) {
        return this.personInfoReadMapper.queryById(psnNo);
    }

    /**
     * 根据查询条件查询数据
     *
     * @param psnInfoBQueryVo
     */
    @Override
    public List<PsnInfoBInfoVo> queryPsnInfoBInfoList(PsnInfoBQueryVo psnInfoBQueryVo) {
        return personInfoReadMapper.queryList(psnInfoBQueryVo);
    }

    /**
     * 根据查询条件分页查询数据
     *
     * @param psnInfoBQueryVo
     * @param pageParam
     * @param need            是否需要查询表中记录的总数
     * @param vague           是否需要进行模糊查询
     */
    @Override
    public Page<PsnInfoBInfoVo> queryPsnInfoBInfoPage(PsnInfoBQueryVo psnInfoBQueryVo, PageParam pageParam, Boolean need, Boolean vague) {
        if (need) {
            Page<PsnInfoBInfoVo> page = new Page<>();
            Long count = personInfoReadMapper.vagueCountNumber(psnInfoBQueryVo);
            page.setTotal(count);
            return page;
        } else {
            personInfoReadMapper.beginPager(pageParam);
            if (vague) {
                return personInfoReadMapper.endPager(personInfoReadMapper.vagueQueryList(psnInfoBQueryVo));
            } else {
                return personInfoReadMapper.endPager(personInfoReadMapper.queryList(psnInfoBQueryVo));
            }
        }
    }

    /**
     * 根据参数值返回包含该参数值的所有主键
     *
     * @param psnNo 主键
     * @return
     */
    @Override
    public List<String> queryPsnNoList(String psnNo) {
        return personInfoReadMapper.queryPsnNoList(psnNo);
    }

    /**
     * 根据查询条件模糊查询数据并进行分页
     *
     * @param psnInfoBQueryVo
     * @param pageParam
     * @return
     */
    @Override
    public Page<PsnInfoBInfoVo> vagueQueryPsnInfoBInfoPage(PsnInfoBQueryVo psnInfoBQueryVo, PageParam pageParam) {
        personInfoReadMapper.beginPager(pageParam);
        return personInfoReadMapper.endPager(personInfoReadMapper.vagueQueryList(psnInfoBQueryVo));
    }

    /**
     * 根据查询条件统计数量
     *
     * @param psnInfoBQueryVo
     * @return
     */
    @Override
    public Long countNumber(PsnInfoBQueryVo psnInfoBQueryVo) {
        return personInfoReadMapper.countNumber(psnInfoBQueryVo);
    }


}