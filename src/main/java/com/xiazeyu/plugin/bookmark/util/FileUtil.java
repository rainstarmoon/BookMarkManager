package com.xiazeyu.plugin.bookmark.util;

import java.io.*;
import java.util.List;

public class FileUtil {

    private static final String CHARSET_UTF8 = "UTF-8";

    public static void inputJavaFile(String inputPath, List<String> contextList) {
        try (
                FileInputStream fis = new FileInputStream(inputPath);
                InputStreamReader isr = new InputStreamReader(fis, CHARSET_UTF8);
                BufferedReader br = new BufferedReader(isr)) {
            String readLine;
            while ((readLine = br.readLine()) != null) {
                contextList.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outputProtoFile(String outputPath, List<String> contextList) {
        try (
                FileOutputStream fos = new FileOutputStream(outputPath);
                OutputStreamWriter osw = new OutputStreamWriter(fos, CHARSET_UTF8);
                BufferedWriter bw = new BufferedWriter(osw)) {
            for (String context : contextList) {
                bw.write(context);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}