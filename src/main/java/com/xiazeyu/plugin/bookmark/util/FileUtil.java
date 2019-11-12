package com.xiazeyu.plugin.bookmark.util;

import java.io.*;
import java.util.List;

public class FileUtil {

    private static final String charsetUTF8 = "UTF-8";

    public static void inputJavaFile(String inputPath, List<String> contextList) {
        try (BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(inputPath), charsetUTF8))) {
            String readLine;
            while ((readLine = read.readLine()) != null) {
                contextList.add(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outputProtoFile(String outputPath, List<String> contextList) {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputPath), charsetUTF8))) {
            for (String context : contextList) {
                out.write(context);
                out.newLine();
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}