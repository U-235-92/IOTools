package io_tools;

import java.io.*;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.zip.*;
public class ToolZipFile {
	public static void zipText(String text, String zip) {
		try(FileOutputStream fos = new FileOutputStream(zip);
				GZIPOutputStream gzos = new GZIPOutputStream(fos);
				BufferedOutputStream bos = new BufferedOutputStream(gzos)) {
			bos.write(text.getBytes());
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static void zipText(String text, File zip) {
		try(FileOutputStream fos = new FileOutputStream(zip);
				GZIPOutputStream gzos = new GZIPOutputStream(fos);
				BufferedOutputStream bos = new BufferedOutputStream(gzos)) {
			bos.write(text.getBytes());
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static String readZipToString(String file) {
		StringBuilder sb = new StringBuilder();
		try(FileInputStream fis = new FileInputStream(file);
				GZIPInputStream gzis = new GZIPInputStream(fis);
				InputStreamReader isr = new InputStreamReader(gzis);
				BufferedReader br = new BufferedReader(isr)) {
			String str = "";
			while((str = br.readLine()) != null) {
				sb.append(str);
			}
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		return sb.toString();
	}
	public static String readZipToString(File file) {
		StringBuilder sb = new StringBuilder();
		try(FileInputStream fis = new FileInputStream(file);
				GZIPInputStream gzis = new GZIPInputStream(fis);
				InputStreamReader isr = new InputStreamReader(gzis);
				BufferedReader br = new BufferedReader(isr)) {
			String str = "";
			while((str = br.readLine()) != null) {
				sb.append(str);
			}
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		return sb.toString();
	}
	public static byte[] readZipToByte(String file) {
		byte[] byteArr = null;
		try(FileInputStream fis = new FileInputStream(file);
				GZIPInputStream gzis = new GZIPInputStream(fis);
				BufferedInputStream bis = new BufferedInputStream(gzis)) {
			byte[] tmp = new byte[bis.available()];
			while(bis.available() != 0) {
				bis.read(tmp);
			}
			byteArr = tmp;
			
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		return byteArr;
	}
	public static byte[] readZipToByte(File file) {
		byte[] byteArr = null;
		try(FileInputStream fis = new FileInputStream(file);
				GZIPInputStream gzis = new GZIPInputStream(fis);
				BufferedInputStream bis = new BufferedInputStream(gzis)) {
			byte[] tmp = new byte[bis.available()];
			while(bis.available() != 0) {
				bis.read(tmp);
			}
			byteArr = tmp;
			
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		return byteArr;
	}
	public static void zipDirectory(File source, File zip) {
		try(FileOutputStream fos = new FileOutputStream(zip);
				ZipOutputStream zos = new ZipOutputStream(fos)) {
			getZipDirectory(zos, source);
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	private static void getZipDirectory(ZipOutputStream zos, File source) throws IOException {
		for(File file : source.listFiles()) {
			String fName = file.getPath();
			if(file.isDirectory()) {
				fName = fName.endsWith("/") ? fName : fName + "/";
				ZipEntry ze = new ZipEntry(fName);
				zos.putNextEntry(ze);
				getZipDirectory(zos, file);
				zos.closeEntry();
			} else {
				ZipEntry ze = new ZipEntry(file.getPath());
				zos.putNextEntry(ze);
				FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				byte[] fBuff = new byte[bis.available()];
				bis.read(fBuff);
				zos.write(fBuff);
				zos.closeEntry();
				bis.close();
			}
		}
	}
	public static void unzipDirectory(File directory, File zip) {
		try {
			unzipDirectory0(directory, zip);
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	private static void unzipDirectory0(File directory, File zip) throws IOException {
		LinkedList<ZipEntry> zEntriesList = new LinkedList<ZipEntry>();
		ZipFile zipFile = new ZipFile(zip);
		Enumeration<?> entries = zipFile.entries();
		while(entries.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) entries.nextElement();
			if(entry.isDirectory()) {
				File dir = new File(directory.getPath() + "/" + entry.getName());
				dir.mkdir();
				
			} else {
				zEntriesList.add(entry);
			}
		}
		for(ZipEntry entry : zEntriesList) {
			InputStream is = (InputStream) zipFile.getInputStream(entry);
			BufferedInputStream bis = new BufferedInputStream(is);
			byte[] buff = new byte[bis.available()];
			bis.read(buff);
			FileOutputStream fos = new FileOutputStream(new File(directory.getPath() + "/" + entry.getName())); 
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(buff);
			bos.close();
			bis.close();
		}
		zipFile.close();
	}
}