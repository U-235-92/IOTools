package io_tools;

import java.io.*;
import java.util.Arrays;
public class ToolBinaryFile {
	public static void readByte(File file) {
		try(BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(file))) {
			byte[] data = new byte[bis.available()];
			bis.read(data);
			System.out.println(Arrays.toString(data));
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static void readByte(String file) {
		try(BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(file))) {
			byte[] data = new byte[bis.available()];
			bis.read(data);
			System.out.println(Arrays.toString(data));
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static void readByteToStr(File file) {
		try(FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr)) {
			String str = "";
			while((str = br.readLine()) != null) {
				System.out.println(str.trim());
			}
		} catch(IOException exc){
			exc.printStackTrace();
		}
	}
}
