package com.yinhai.demo.service.write;

import com.yinhai.demo.entity.PsnInfoB;
import com.yinhai.demo.vo.PsnInfoBAddVo;
import com.yinhai.demo.vo.PsnInfoBEditVo;

/**
* 人员基本信息(PsnInfoB)表服务接口
*
* @author default
* @since 2020-08-17 22:45:18
*/
public interface PersonInfoWriteService {
    /**
    * 新增数据
    *
    * @param psnInfoBAddVo 实例对象
    * @return 实例对象
    */
    PsnInfoB addPsnInfoBInfo(PsnInfoBAddVo psnInfoBAddVo);

    /**
    * 修改数据
    *
    * @param psnInfoBEditVo 实例对象
    * @return 实例对象
    */
    PsnInfoB editPsnInfoBInfo(PsnInfoBEditVo psnInfoBEditVo);

    /**
    * 通过主键物理删除数据
    *
    * @param psnNo 主键
    * @return 是否成功
    */
    int removePsnInfoBById(String psnNo);


    /**
    * 通过主键逻辑删除数据
    *
    * @param psnNo 主键
    * @return 是否成功
    */
    int logicRemovePsnInfoBById(String psnNo);


}