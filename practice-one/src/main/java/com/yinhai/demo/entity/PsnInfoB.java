package com.yinhai.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
* 人员基本信息(PsnInfoB)实体类
*
* @author default
* @since 2020-08-17 22:45:18
*/
public class PsnInfoB implements Serializable {
    private static final long serialVersionUID = -72687051644762199L;
            //人员编号
    private String psnNo;
            //人员管理码
    private String psnMgtcode;
            //人员姓名
    private String psnName;
            //别名
    private String alis;
            //性别
    private String gend;
            //出生日期
    private Date brdy;
            //人员证件类型
    private String psnCertType;
            //证件号码
    private String certno;
            //电子凭证号
    private String hsecfc;
            //联系电话
    private String tel;
            //手机号码
    private String mob;
            //民族
    private String naty;
            //国家地区代码
    private String natRegnCode;
            //电子邮箱
    private String email;
            //政治面貌
    private String polstas;
            //首次参加工作日期
    private Date fstPatcJobDate;
            //户口性质
    private String resdNatu;
            //户口所在地行政区
    private String resdLocAdmdvs;
            //户口地址
    private String resdAddr;
            //户口所在地邮政编码
    private String resdAddrPoscode;
            //居住地行政区
    private String liveAdmdvs;
            //居住地址
    private String liveAddr;
            //居住地邮政编码
    private String liveAddrPoscode;
            //户口簿编号
    private String resdbookNo;
            //婚姻状况
    private String mrgStas;
            //健康状况
    private String hlcon;
            //备注
    private String memo;
            //生存状态
    private String survStas;
            //多省维护标志
    private String mulProvMntFlag;
            //行政职务
    private String admdut;
            //离退休类型
    private String retrType;
            //毕业院校
    private String gradSchl;
            //学历
    private String educ;
            //专业技术职务等级
    private String proTechDutyLv;
            //国家职业资格等级
    private String natPrfsQuaLv;
            //有效标志
    private String valiFlag;
            //唯一记录号
    private String rid;
            //数据创建时间
    private Date crteTime;
            //数据更新时间
    private Date updtTime;
            //创建人
    private String crter;
            //创建人姓名
    private String crterName;
            //创建经办机构
    private String crteOptins;
            //经办人
    private String opter;
            //经办人姓名
    private String opterName;
            //经办时间
    private Date optTime;
            //经办机构
    private String optins;
            //版本号
    private String ver;
    
                
public String getPsnNo() {
return psnNo;
}

public void setPsnNo(String psnNo) {
this.psnNo = psnNo;
}
                
public String getPsnMgtcode() {
return psnMgtcode;
}

public void setPsnMgtcode(String psnMgtcode) {
this.psnMgtcode = psnMgtcode;
}
                
public String getPsnName() {
return psnName;
}

public void setPsnName(String psnName) {
this.psnName = psnName;
}
                
public String getAlis() {
return alis;
}

public void setAlis(String alis) {
this.alis = alis;
}
                
public String getGend() {
return gend;
}

public void setGend(String gend) {
this.gend = gend;
}
                
public Date getBrdy() {
return brdy;
}

public void setBrdy(Date brdy) {
this.brdy = brdy;
}
                
public String getPsnCertType() {
return psnCertType;
}

public void setPsnCertType(String psnCertType) {
this.psnCertType = psnCertType;
}
                
public String getCertno() {
return certno;
}

public void setCertno(String certno) {
this.certno = certno;
}
                
public String getHsecfc() {
return hsecfc;
}

public void setHsecfc(String hsecfc) {
this.hsecfc = hsecfc;
}
                
public String getTel() {
return tel;
}

public void setTel(String tel) {
this.tel = tel;
}
                
public String getMob() {
return mob;
}

public void setMob(String mob) {
this.mob = mob;
}
                
public String getNaty() {
return naty;
}

public void setNaty(String naty) {
this.naty = naty;
}
                
public String getNatRegnCode() {
return natRegnCode;
}

public void setNatRegnCode(String natRegnCode) {
this.natRegnCode = natRegnCode;
}
                
public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}
                
public String getPolstas() {
return polstas;
}

public void setPolstas(String polstas) {
this.polstas = polstas;
}
                
public Date getFstPatcJobDate() {
return fstPatcJobDate;
}

public void setFstPatcJobDate(Date fstPatcJobDate) {
this.fstPatcJobDate = fstPatcJobDate;
}
                
public String getResdNatu() {
return resdNatu;
}

public void setResdNatu(String resdNatu) {
this.resdNatu = resdNatu;
}
                
public String getResdLocAdmdvs() {
return resdLocAdmdvs;
}

public void setResdLocAdmdvs(String resdLocAdmdvs) {
this.resdLocAdmdvs = resdLocAdmdvs;
}
                
public String getResdAddr() {
return resdAddr;
}

public void setResdAddr(String resdAddr) {
this.resdAddr = resdAddr;
}
                
public String getResdAddrPoscode() {
return resdAddrPoscode;
}

public void setResdAddrPoscode(String resdAddrPoscode) {
this.resdAddrPoscode = resdAddrPoscode;
}
                
public String getLiveAdmdvs() {
return liveAdmdvs;
}

public void setLiveAdmdvs(String liveAdmdvs) {
this.liveAdmdvs = liveAdmdvs;
}
                
public String getLiveAddr() {
return liveAddr;
}

public void setLiveAddr(String liveAddr) {
this.liveAddr = liveAddr;
}
                
public String getLiveAddrPoscode() {
return liveAddrPoscode;
}

public void setLiveAddrPoscode(String liveAddrPoscode) {
this.liveAddrPoscode = liveAddrPoscode;
}
                
public String getResdbookNo() {
return resdbookNo;
}

public void setResdbookNo(String resdbookNo) {
this.resdbookNo = resdbookNo;
}
                
public String getMrgStas() {
return mrgStas;
}

public void setMrgStas(String mrgStas) {
this.mrgStas = mrgStas;
}
                
public String getHlcon() {
return hlcon;
}

public void setHlcon(String hlcon) {
this.hlcon = hlcon;
}
                
public String getMemo() {
return memo;
}

public void setMemo(String memo) {
this.memo = memo;
}
                
public String getSurvStas() {
return survStas;
}

public void setSurvStas(String survStas) {
this.survStas = survStas;
}
                
public String getMulProvMntFlag() {
return mulProvMntFlag;
}

public void setMulProvMntFlag(String mulProvMntFlag) {
this.mulProvMntFlag = mulProvMntFlag;
}
                
public String getAdmdut() {
return admdut;
}

public void setAdmdut(String admdut) {
this.admdut = admdut;
}
                
public String getRetrType() {
return retrType;
}

public void setRetrType(String retrType) {
this.retrType = retrType;
}
                
public String getGradSchl() {
return gradSchl;
}

public void setGradSchl(String gradSchl) {
this.gradSchl = gradSchl;
}
                
public String getEduc() {
return educ;
}

public void setEduc(String educ) {
this.educ = educ;
}
                
public String getProTechDutyLv() {
return proTechDutyLv;
}

public void setProTechDutyLv(String proTechDutyLv) {
this.proTechDutyLv = proTechDutyLv;
}
                
public String getNatPrfsQuaLv() {
return natPrfsQuaLv;
}

public void setNatPrfsQuaLv(String natPrfsQuaLv) {
this.natPrfsQuaLv = natPrfsQuaLv;
}
                
public String getValiFlag() {
return valiFlag;
}

public void setValiFlag(String valiFlag) {
this.valiFlag = valiFlag;
}
                
public String getRid() {
return rid;
}

public void setRid(String rid) {
this.rid = rid;
}
                
public Date getCrteTime() {
return crteTime;
}

public void setCrteTime(Date crteTime) {
this.crteTime = crteTime;
}
                
public Date getUpdtTime() {
return updtTime;
}

public void setUpdtTime(Date updtTime) {
this.updtTime = updtTime;
}
                
public String getCrter() {
return crter;
}

public void setCrter(String crter) {
this.crter = crter;
}
                
public String getCrterName() {
return crterName;
}

public void setCrterName(String crterName) {
this.crterName = crterName;
}
                
public String getCrteOptins() {
return crteOptins;
}

public void setCrteOptins(String crteOptins) {
this.crteOptins = crteOptins;
}
                
public String getOpter() {
return opter;
}

public void setOpter(String opter) {
this.opter = opter;
}
                
public String getOpterName() {
return opterName;
}

public void setOpterName(String opterName) {
this.opterName = opterName;
}
                
public Date getOptTime() {
return optTime;
}

public void setOptTime(Date optTime) {
this.optTime = optTime;
}
                
public String getOptins() {
return optins;
}

public void setOptins(String optins) {
this.optins = optins;
}
                
public String getVer() {
return ver;
}

public void setVer(String ver) {
this.ver = ver;
}
    
}