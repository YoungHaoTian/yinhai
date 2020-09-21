package com.yinhai.demo.rest;

import com.yinhai.demo.entity.PsnInfoB;
import com.yinhai.demo.service.read.PersonInfoReadService;
import com.yinhai.demo.service.write.PersonInfoWriteService;
import com.yinhai.demo.utils.RequestResult;
import com.yinhai.demo.vo.PsnInfoBAddVo;
import com.yinhai.demo.vo.PsnInfoBEditVo;
import com.yinhai.demo.vo.PsnInfoBInfoVo;
import com.yinhai.demo.vo.PsnInfoBQueryVo;
import com.yinhai.ta404.core.restservice.BaseRestService;
import com.yinhai.ta404.core.restservice.annotation.RestService;
import com.yinhai.ta404.core.restservice.requestbean.PageParam;
import com.yinhai.ta404.core.validate.annotation.V;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.yinhai.demo.utils.RequestResult.fail;
import static com.yinhai.demo.utils.RequestResult.success;

/**
 * 人员基本信息(PsnInfoB)表控制层
 *
 * @author default
 * @since 2020-08-17 22:45:18
 */
@Validated
@RestService("personInfo")
public class PersonInfoRestService extends BaseRestService {
    /**
     * 服务对象
     */
    @Resource
    private PersonInfoReadService personInfoReadService;
    @Resource
    private PersonInfoWriteService personInfoWriteService;

    /**
     * 新增数据
     *
     * @param psnInfoBAddVo
     */
    @PostMapping("addPsnInfoBInfo")
    public RequestResult addPsnInfoBInfo(@Valid PsnInfoBAddVo psnInfoBAddVo) {
        PsnInfoB psnInfoB = personInfoWriteService.addPsnInfoBInfo(psnInfoBAddVo);
        return RequestResult.success(psnInfoB, "新增人员信息成功");
    }

    /**
     * 通过主键物理删除数据
     *
     * @param psnNo 主键
     */
    @PostMapping("removePsnInfoBById")
    public void removePsnInfoBById(@V({"notnull"}) String psnNo) {
        personInfoWriteService.removePsnInfoBById(psnNo);
    }

    /**
     * 通过主键逻辑删除数据
     *
     * @param psnNo 主键
     */
    @PostMapping("removePsnInfoB")
    public void logicRemovePsnInfoB(@V({"notnull"}) String psnNo) {
        personInfoWriteService.logicRemovePsnInfoBById(psnNo);
    }

    /**
     * 编辑数据
     *
     * @param psnInfoBEditVo
     */
    @PostMapping("editPsnInfoBInfo")
    public RequestResult editPsnInfoBInfo(@Valid PsnInfoBEditVo psnInfoBEditVo) {
        //根据人员编号psnNo，查询出对应的记录
        PsnInfoBInfoVo psnInfoBInfoVo = personInfoReadService.queryPsnInfoBInfoById(psnInfoBEditVo.getPsnNo());
        //姓名验证
        if (psnInfoBEditVo.getPsnName() == null || "".equals(psnInfoBEditVo.getPsnName())) {
            return fail(null, "请输入姓名");
        } else if (psnInfoBEditVo.getPsnName().equals(psnInfoBInfoVo.getPsnName())) {
            psnInfoBEditVo.setPsnName(null);
        }

        //别名验证（别名可以是空字符串）
        if (psnInfoBEditVo.getAlis() != null && psnInfoBEditVo.getAlis().equals(psnInfoBInfoVo.getAlis())) {
            psnInfoBEditVo.setAlis(null);
        }

        //证件类型验证
        if (psnInfoBEditVo.getPsnCertType() == null) {
            return fail(null, "请选择证件类型");
        } else if (psnInfoBEditVo.getPsnCertType().equals(psnInfoBInfoVo.getPsnCertType())) {
            psnInfoBEditVo.setPsnCertType(null);
        }

        //先判断证件号是否需要修改
        //证件号与原证件号不一致，即需要修改证件号码，则要验证是否重复
        if (psnInfoBEditVo.getCertno() == null || "".equals(psnInfoBEditVo.getCertno())) {//未填入证件号码
            return RequestResult.fail(null, "请输入证件号码");
        } else if (!psnInfoBEditVo.getCertno().equals(psnInfoBInfoVo.getCertno())) {
            PsnInfoBQueryVo queryVo = new PsnInfoBQueryVo();
            if (psnInfoBEditVo.getPsnCertType() == null) {
                queryVo.setPsnCertType(psnInfoBInfoVo.getPsnCertType());
            } else {
                queryVo.setPsnCertType(psnInfoBEditVo.getPsnCertType());
            }
            queryVo.setCertno(psnInfoBEditVo.getCertno());
            List<PsnInfoBInfoVo> list = personInfoReadService.queryPsnInfoBInfoList(queryVo);
            if (!list.isEmpty()) {//该证件类型的证件号码重复
                return fail(null, "该类型的证件号码已经存在，请重新输入");
            }
        } else {
            psnInfoBEditVo.setCertno(null);
        }

        //性别验证
        if (psnInfoBEditVo.getGend() == null) {
            return RequestResult.fail(null, "请选择性别");
        } else if (psnInfoBEditVo.getGend().equals(psnInfoBInfoVo.getGend())) {
            psnInfoBEditVo.setGend(null);
        }

        //出生日期验证
        if (psnInfoBEditVo.getBrdy() == null) {
            return RequestResult.fail(null, "请选择出生日期");
        } else if (psnInfoBEditVo.getBrdy().equals(psnInfoBInfoVo.getBrdy())) {
            psnInfoBEditVo.setBrdy(null);
        }

        //联系电话验证
        if (psnInfoBEditVo.getTel() != null && !"".equals(psnInfoBEditVo.getTel()) && !psnInfoBEditVo.getTel().equals(psnInfoBInfoVo.getTel())) {
            PsnInfoBQueryVo queryVo = new PsnInfoBQueryVo();
            queryVo.setTel(psnInfoBEditVo.getTel());
            List<PsnInfoBInfoVo> list = personInfoReadService.queryPsnInfoBInfoList(queryVo);
            if (!list.isEmpty()) {//联系电话重复
                return fail(null, "该联系电话已经存在，请重新输入");
            }
        } else if (psnInfoBEditVo.getTel() != null && psnInfoBEditVo.getTel().equals(psnInfoBInfoVo.getTel())) {
            psnInfoBEditVo.setTel(null);
        }

        //手机号码验证
        if (psnInfoBEditVo.getMob() == null || "".equals(psnInfoBEditVo.getMob())) {
            return RequestResult.fail(null, "请输入手机号码");
        } else if (!psnInfoBEditVo.getMob().equals(psnInfoBInfoVo.getMob())) {
            PsnInfoBQueryVo queryVo = new PsnInfoBQueryVo();
            queryVo.setMob(psnInfoBEditVo.getMob());
            List<PsnInfoBInfoVo> list = personInfoReadService.queryPsnInfoBInfoList(queryVo);
            if (!list.isEmpty()) {//手机号码重复
                return fail(null, "该手机号码已经存在，请重新输入");
            }
        } else {
            psnInfoBEditVo.setMob(null);
        }

        //邮箱地址验证
        if (psnInfoBEditVo.getEmail() == null || "".equals(psnInfoBEditVo.getEmail())) {
            return RequestResult.fail(null, "请输入邮箱地址");
        } else if (!psnInfoBEditVo.getEmail().equals(psnInfoBInfoVo.getEmail())) {
            PsnInfoBQueryVo queryVo = new PsnInfoBQueryVo();
            queryVo.setEmail(psnInfoBEditVo.getEmail());
            List<PsnInfoBInfoVo> list = personInfoReadService.queryPsnInfoBInfoList(queryVo);
            if (!list.isEmpty()) {
                return fail(null, "该邮箱地址已经存在，请重新输入");
            }
        } else {
            psnInfoBEditVo.setEmail(null);
        }

        //居住地址验证
        if (psnInfoBEditVo.getLiveAddr() == null || "".equals(psnInfoBEditVo.getLiveAddr())) {
            return fail(null, "请输入居住地址");
        } else if (psnInfoBEditVo.getLiveAddr().equals(psnInfoBInfoVo.getLiveAddr())) {
            psnInfoBEditVo.setLiveAddr(null);
        }

        //所属民族验证
        if (psnInfoBEditVo.getNaty() == null) {
            return fail(null, "请选择所属民族");
        } else if (psnInfoBEditVo.getNaty().equals(psnInfoBInfoVo.getNaty())) {
            psnInfoBEditVo.setNaty(null);
        }
        personInfoWriteService.editPsnInfoBInfo(psnInfoBEditVo);
        return success(null, "修改人员信息成功");
    }

    /**
     * 根据主键查询数据
     *
     * @param psnNo 主键
     */
    @PostMapping("queryPsnInfoBInfoById")
    public PsnInfoBInfoVo queryPsnInfoBInfoById(@V({"notnull"}) String psnNo) {
        return personInfoReadService.queryPsnInfoBInfoById(psnNo);
    }

    /**
     * 根据查询条件查询数据
     *
     * @param psnInfoBQueryVo
     */
    @PostMapping("queryPsnInfoBInfoList")
    public List<PsnInfoBInfoVo> queryPsnInfoBInfoList(PsnInfoBQueryVo psnInfoBQueryVo) {
        return personInfoReadService.queryPsnInfoBInfoList(psnInfoBQueryVo);
    }

    /**
     * 根据查询条件分页查询数据
     *
     * @param psnInfoBQueryVo
     * @param pageParam
     * @param need            是否需要查询表中记录的总数
     * @param vague           是否需要进行模糊查询
     */
    @PostMapping("queryPsnInfoBInfoPage")
    public void queryPsnInfoBInfoPage(PsnInfoBQueryVo psnInfoBQueryVo, PageParam pageParam,
                                      @RequestParam(value = "needCount", required = false, defaultValue = "false") Boolean need,
                                      @RequestParam(value = "vague", required = false, defaultValue = "false") Boolean vague) {
        setPageBean(personInfoReadService.queryPsnInfoBInfoPage(psnInfoBQueryVo, pageParam, need, vague));
    }

    /**
     * 根据参数值返回包含该参数值的所有主键
     *
     * @param psnNo 主键
     * @return
     */
    @PostMapping("queryPsnNoList")
    public List<String> queryPsnNoList(@V({"notnull"}) String psnNo) {
        return personInfoReadService.queryPsnNoList(psnNo);
    }

    /**
     * 根据查询条件模糊查询数据并进行分页
     *
     * @param psnInfoBQueryVo
     * @param pageParam
     */
    @PostMapping("vagueQueryPsnInfoBInfoPage")
    public void vagueQueryPsnInfoBInfoPage(PsnInfoBQueryVo psnInfoBQueryVo, PageParam pageParam) {
        setPageBean(personInfoReadService.vagueQueryPsnInfoBInfoPage(psnInfoBQueryVo, pageParam));
    }

    /**
     * 根据查询条件统计数量
     *
     * @param psnInfoBQueryVo
     * @return
     */
    @PostMapping("countNumber")
    public Long countNumber(PsnInfoBQueryVo psnInfoBQueryVo) {
        return personInfoReadService.countNumber(psnInfoBQueryVo);
    }
}