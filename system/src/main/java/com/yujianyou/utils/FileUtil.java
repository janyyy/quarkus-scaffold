package com.yujianyou.utils;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.UUID;
import com.yujianyou.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.MessageDigest;

/**
 * FileUtil
 */
@Slf4j
public class FileUtil extends cn.hutool.core.io.FileUtil {

    public static final String SYS_TEM_DIR = System.getProperty("java.io.tmpdir") + File.separator;


    /**
     * 从InputPart中获取输入流
     *
     * @param inputPart /
     * @return /
     * @throws IOException /
     */
    public static InputStream getInputStreamFromInputPart(InputPart inputPart) throws IOException {
        return inputPart.getBody(InputStream.class, null);
    }

    /**
     * 从InputPart中获取文件名称
     *
     * @param inputPart /
     * @return /
     */
    public static String getFileNameFromInputPart(InputPart inputPart) {
        String[] contentDisposition = inputPart.getHeaders().getFirst("Content-Disposition").split(";");
        String fileName = null;
        for (String name : contentDisposition) {
            if (name.trim().startsWith("filename=")) {
                String[] arr = name.split("=");
                fileName = arr[1].trim().replaceAll("\"", "");
                fileName = new String(fileName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                break;
            }
        }
        return StringUtil.isEmpty(fileName) ? UUID.fastUUID().toString(true) : fileName;
    }

    /**
     * 文件复制
     *
     * @param path     /
     * @param filePath /
     */
    public static void moveFileToDest(Path path, String filePath) {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            File zipPathFile = path.toFile();
            in = FileUtil.getInputStream(zipPathFile.getAbsolutePath());
            out = FileUtil.getOutputStream(filePath);
            IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);
        } catch (Exception e) {
            log.error("move file error !");
        } finally {
            //先关闭外层的流，再关闭内层的流
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            FileUtil.del(path);
        }
    }

    /**
     * 获取文件名后缀
     *
     * @param filename /
     * @return /
     */
    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }

    /**
     * 判断文件大小
     *
     * @param maxSize /
     * @param size    /
     */
    public static void checkSize(long maxSize, long size) {
        int len = 1024 * 1024;
        if (size > (maxSize * len)) {
            throw new BadRequestException("文件超出规定大小");
        }
    }

    public static File inputStreamToFile(InputStream ins, String name) {
        File file = new File(SYS_TEM_DIR + name);
        if (file.exists()) {
            return file;
        }
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int bytesRead;
            int len = 8192;
            byte[] buffer = new byte[len];
            while ((bytesRead = ins.read(buffer, 0, len)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CloseUtil.close(os);
            CloseUtil.close(ins);
        }
        return file;
    }

    private static byte[] getByte(File file) {


        byte[] b = new byte[(int) file.length()];
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            try {
                System.out.println(in.read(b));
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        } finally {
            CloseUtil.close(in);
        }
        return b;
    }

    public static boolean check(String file1Md5, String file2Md5) {
        return file1Md5.equals(file2Md5);
    }

    public static boolean check(File file1, File file2) {
        String img1Md5 = getMd5(file1);
        String img2Md5 = getMd5(file2);
        if (img1Md5 != null) {
            return img1Md5.equals(img2Md5);
        }
        return false;
    }

    public static String getMd5(File file) {
        return getMd5(getByte(file));
    }

    private static String getMd5(byte[] bytes) {


        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(bytes);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;


            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
