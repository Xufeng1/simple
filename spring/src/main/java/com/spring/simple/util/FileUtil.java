package com.spring.simple.util;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 文件处理工具
 * Created by fengxu on 15-12-15.
 */
public class FileUtil {

    public static Map<String, String> propertiesToMap(File file) throws IOException {
        return Files.readLines(file, Charsets.UTF_8, new LineProcessor<Map<String, String>>() {
            Map<String, String> properties = Maps.newHashMap();

            @Override
            public boolean processLine(String line) throws IOException, IllegalArgumentException {
                List<String> keyAndValue = Splitter.on("=").trimResults().omitEmptyStrings().splitToList(line);
                if (keyAndValue.size() == 2) {
                    properties.put(keyAndValue.get(0), keyAndValue.get(1));
                    return true;
                } else {
                    throw new IllegalArgumentException("文件内容格式不正确");
                }
            }

            @Override
            public Map<String, String> getResult() {
                return properties;
            }
        });
    }

    public static String fileToString(File file) throws IOException {
        return Files.readLines(file, Charsets.UTF_8, new LineProcessor<String>() {
            StringBuilder content = new StringBuilder();

            @Override
            public boolean processLine(String line) throws IOException {
                content.append(line).append("\n");
                return true;
            }

            @Override
            public String getResult() {
                return content.toString();
            }
        });
    }
}
