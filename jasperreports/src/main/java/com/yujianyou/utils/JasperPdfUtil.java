package com.yujianyou.utils;

import cn.hutool.core.io.resource.ResourceUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;

import java.util.Map;

/**
 * @author yujianyou
 * @date 2022/1/11 15:03
 * @email 597907730@qq.com
 */
public class JasperPdfUtil {

    private JasperPdfUtil() {
    }

    /**
     * 导出 PDF
     *
     * @param templatePath jrxml 模板路径(base classpath)
     * @param paramMap     数据对象
     * @return /
     * @throws JRException /
     */
    public static byte[] exportPdfFromXml(String templatePath, Map<String, Object> paramMap) throws JRException {
        JasperReport jasperReport = getJasperReportFromXml(templatePath);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramMap, new JREmptyDataSource());

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }


    /**
     * 导出 PDF
     *
     * @param templatePath jasper 模板路径(base classpath)
     * @param paramMap     数据对象
     * @return /
     * @throws JRException /
     */
    public static byte[] exportPdfFromJasper(String templatePath, Map<String, Object> paramMap) throws JRException {
        JasperReport jasperReport = getJasperReportFromJasper(templatePath);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramMap, new JREmptyDataSource());
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    /**
     * 获取导出对象,从 xml 中
     *
     * @param templatePath 模板路径(base classpath)
     * @return /
     * @throws JRException /
     */
    private static JasperReport getJasperReportFromXml(String templatePath) throws JRException {
        return JasperCompileManager.compileReport(ResourceUtil.getStream(templatePath));
    }


    /**
     * 获取导出对象,从 jasper 中
     * (jasper 为 jrxml 编译后生成的文件)
     *
     * @param templatePath 模板路径(base classpath)
     * @return /
     * @throws JRException /
     */
    private static JasperReport getJasperReportFromJasper(String templatePath) throws JRException {
        return (JasperReport) JRLoader.loadObject(ResourceUtil.getStream(templatePath));
    }

}
