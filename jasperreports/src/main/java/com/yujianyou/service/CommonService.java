package com.yujianyou.service;

import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

/**
 * @author yujianyou
 * @date 2022/1/11 15:15
 * @email 597907730@qq.com
 */
public interface CommonService {
    /**
     * PDF 文件导出 2
     *
     * @return /
     * @throws FileNotFoundException /
     * @throws JRException           /
     */
    byte[] exportPdf2() throws FileNotFoundException, JRException;
}
