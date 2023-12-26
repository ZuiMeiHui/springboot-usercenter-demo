package com.zuimeihui.demo.common.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 文件工具类
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-12-23 11:36:21
 */
public class FileUtil {

	/**
	 * 读取文件内容
	 *
	 * @param filePath 文件路径
	 * @return 文件内容
	 * @throws IOException 如果读取文件失败
	 */
	public static String readFile(String filePath) throws IOException {
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append(System.lineSeparator());
			}
		}
		return content.toString();
	}

	/**
	 * 写入文件内容
	 *
	 * @param filePath 文件路径
	 * @param content  写入的内容
	 * @throws IOException 如果写入文件失败
	 */
	public static void writeFile(String filePath, String content) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			writer.write(content);
		}
	}

	/**
	 * 复制文件
	 *
	 * @param sourceFilePath 源文件路径
	 * @param destFilePath   目标文件路径
	 * @throws IOException 如果复制文件失败
	 */
	public static void copyFile(String sourceFilePath, String destFilePath) throws IOException {
		Path source = Paths.get(sourceFilePath);
		Path dest = Paths.get(destFilePath);
		Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
	}

	/**
	 * 删除文件
	 *
	 * @param filePath 文件路径
	 * @throws IOException 如果删除文件失败
	 */
	public static void deleteFile(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		Files.deleteIfExists(path);
	}

	/**
	 * 获取文件大小
	 *
	 * @param filePath 文件路径
	 * @return 文件大小，单位为字节
	 * @throws IOException 如果获取文件大小失败
	 */
	public static long getFileSize(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		return Files.size(path);
	}

	/**
	 * 判断文件是否存在
	 *
	 * @param filePath 文件路径
	 * @return true 如果文件存在；false 如果文件不存在
	 */
	public static boolean fileExists(String filePath) {
		Path path = Paths.get(filePath);
		return Files.exists(path);
	}

	/**
	 * 创建目录
	 *
	 * @param directoryPath 目录路径
	 * 
	 * 
	 * @throws IOException 如果创建目录失败
	 */
	public static void createDirectory(String directoryPath) throws IOException {
		Path path = Paths.get(directoryPath);
		Files.createDirectories(path);
	}

	/**
	 * 获取文件扩展名
	 *
	 * @param fileName 文件名
	 * @return 文件扩展名
	 */
	public static String getFileExtension(String fileName) {
		if (StringUtils.isBlank(fileName)) {
			return "";
		}
		int index = fileName.lastIndexOf(".");
		if (index != -1) {
			return fileName.substring(index + 1);
		}
		return "";
	}

	/**
	 * 获取文件行数
	 *
	 * @param filePath 文件路径
	 * @return 文件行数
	 * @throws IOException 如果读取文件失败
	 */
	public static int getFileLineCount(String filePath) throws IOException {
		int count = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			while (reader.readLine() != null) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 获取文件列表
	 *
	 * @param directoryPath 目录路径
	 * @return 文件列表
	 * @throws IOException 如果读取目录失败
	 */
	public static List<String> getFileList(String directoryPath) throws IOException {
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryPath))) {
			List<String> fileList = new ArrayList<>();
			for (Path path : directoryStream) {
				if (Files.isRegularFile(path)) {
					fileList.add(path.getFileName().toString());
				}
			}
			return fileList;
		}
	}

	/**
	 * 重命名文件
	 *
	 * @param filePath    文件路径
	 * @param newFileName 新文件名
	 * @throws IOException 如果重命名文件失败
	 */
	public static void renameFile(String filePath, String newFileName) throws IOException {
		Path source = Paths.get(filePath);
		Path target = source.resolveSibling(newFileName);
		Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
	}
}
