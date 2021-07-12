package io_tools;
import java.io.*;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		ToolDateFile.writeInteger(new File("tasks/io_tools/DataInt.txt"), arr);
		int[] arrReaded = ToolDateFile.readArrInteger(new File("tasks/io_tools/DataInt.txt"));
		System.out.println(Arrays.toString(arrReaded));
		String str = "DATA";
		ToolDateFile.writeUTF("tasks/io_tools/DataUTF.txt", str);
		String strReaded = ToolDateFile.readUTF("tasks/io_tools/DataUTF.txt");
		System.out.println(strReaded);
		ToolBinaryFile.readByte("tasks/io_tools/DataUTF.txt");
		ToolBinaryFile.readByteToStr(new File("tasks/io_tools/DataUTF.txt"));
		ToolZipFile.zipText("ZIP Archive", new File("tasks/io_tools/gzip.gz"));
		String gzipRead = ToolZipFile.readZipToString(new File("tasks/io_tools/gzip.gz"));
		System.out.println(gzipRead);
		byte[] bytes = ToolZipFile.readZipToByte(new File("tasks/io_tools/gzip.gz"));
		System.out.println(Arrays.toString(bytes));
		ToolZipFile.zipDirectory(new File("tasks/directory"), new File("tasks/zip_directory.zip"));
		ToolZipFile.unzipDirectory(new File("tasks/unzip"), new File("tasks/zip_directory.zip"));
//		try {
//			ToolZipFile.unpack("tasks/zip_directory.zip", "tasks/unzip");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
