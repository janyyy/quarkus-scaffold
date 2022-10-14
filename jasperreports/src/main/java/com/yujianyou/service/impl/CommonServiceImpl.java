package com.yujianyou.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.core.util.IdUtil;
import com.yujianyou.entity.ContractEntity;
import com.yujianyou.service.CommonService;
import com.yujianyou.utils.JasperPdfUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author yujianyou
 * @date 2022/1/11 15:16
 * @email 597907730@qq.com
 */
@Slf4j
@ApplicationScoped
public class CommonServiceImpl implements CommonService {
    /**
     * PDF 文件导出 2
     *
     * @return /
     * @throws JRException /
     */
    @Override
    public byte[] exportPdf2() throws JRException {
        String templatePath = "pdf/template/contract.jrxml";
        ContractEntity contract = new ContractEntity();
        contract.setContractCode("CON11123445567778888");
        contract.setContractName("马尔代夫海景房转让合同");
        contract.setContractOriginalCode("ORI555444333222111");
        contract.setOriginalCcyTaxIncludedAmt(new BigDecimal("123456789.12345666666").setScale(6, BigDecimal.ROUND_DOWN));
        contract.setLocalCcyTaxIncludedAmt(new BigDecimal("987654321.123456"));
        contract.setContractType("租赁合同");
        contract.setContractDetailType("房屋租赁合同");
        //todo 强制left to right排序优化，针对希伯来语、阿拉伯语
        contract.setSupplierName(UnicodeUtil.toString("\\u2066 " + "ששת הימים 1 דירה 6 קומה 2 "));
        contract.setOperatorName("德玛西亚");
        contract.setOperatorOrgName("稀里糊涂银行总行");
        contract.setOperatorDeptName("马尔代夫总行财务部");
        contract.setEffectiveDate(new Date());
        contract.setExpiredDate(new Date());

        contract.setBarcode(IdUtil.fastSimpleUUID());
        return JasperPdfUtil.exportPdfFromXml(templatePath, BeanUtil.beanToMap(contract));
    }


}
