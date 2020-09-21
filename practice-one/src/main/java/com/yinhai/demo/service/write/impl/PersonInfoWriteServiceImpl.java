package com.yinhai.demo.service.write.impl;

import com.yinhai.demo.entity.PsnInfoB;
import com.yinhai.demo.mapper.write.PersonInfoWriteMapper;
import com.yinhai.demo.service.write.PersonInfoWriteService;
import com.yinhai.demo.vo.PsnInfoBAddVo;
import com.yinhai.demo.vo.PsnInfoBEditVo;
import com.yinhai.ta404.core.exception.AppException;
import com.yinhai.ta404.core.service.BaseService;
import com.yinhai.ta404.core.transaction.annotation.TaTransactional;
import com.yinhai.ta404.module.mybatis.dao.impl.SequenceDaoImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;


/**
 * 人员基本信息(PsnInfoB)表服务实现类
 *
 * @author default
 * @since 2020-08-17 22:45:18
 */
@Service
@TaTransactional
public class PersonInfoWriteServiceImpl extends BaseService implements PersonInfoWriteService {
    @Resource
    private PersonInfoWriteMapper personInfoWriteMapper;
    @Resource
    private SequenceDaoImpl sequenceDao;


    /**
     * 新增数据
     *
     * @param psnInfoBAddVo 实例对象
     * @return 实例对象
     */
    @Override
    public PsnInfoB addPsnInfoBInfo(PsnInfoBAddVo psnInfoBAddVo) {
        PsnInfoB psnInfoB = new PsnInfoB();
        BeanUtils.copyProperties(psnInfoBAddVo, psnInfoB);

        Timestamp time=getSysTimestamp();
        psnInfoB.setCrteTime(time);
        psnInfoB.setUpdtTime(time);
        int i = personInfoWriteMapper.insert(psnInfoB);
        if (i != 1) {
            throw new AppException("未添加任何数据，请重试");
        }
        return psnInfoB;
    }

    /**
     * 修改数据
     *
     * @param psnInfoBEditVo 实例对象
     * @return 实例对象
     */
    @Override
    public PsnInfoB editPsnInfoBInfo(PsnInfoBEditVo psnInfoBEditVo) {
        PsnInfoB psnInfoB = new PsnInfoB();
        BeanUtils.copyProperties(psnInfoBEditVo, psnInfoB);
        psnInfoB.setUpdtTime(getSysTimestamp());
        int i = personInfoWriteMapper.update(psnInfoB);
        if (i != 1) {
            throw new AppException("未更新任何数据，请重试");
        }
        return psnInfoB;
    }

    /**
     * 通过主键物理删除数据
     *
     * @param psnNo 主键
     * @return 受影响行数
     */
    @Override
    public int removePsnInfoBById(String psnNo) {
        int i = this.personInfoWriteMapper.deleteById(psnNo);
        if (i == 0) throw new AppException("未删除任何数据，请重试");
        return i;
    }

    /**
     * 通过主键逻辑删除数据
     *
     * @param psnNo 主键
     * @return 受影响行数
     */
    @Override
    public int logicRemovePsnInfoBById(String psnNo) {
        int i = this.personInfoWriteMapper.updateToDestroyById(psnNo);
        if (i == 0) throw new AppException("未删除任何数据，请重试");
        return i;
    }



}