package io_tools;

import java.io.*;
public class ToolDateFile {
	public static int readInteger(String file) {
		int read = 0;
		try(FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				DataInputStream dis = new DataInputStream(bis)) {
			read = dis.readInt();
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		return read;
	}
	public static int readInteger(File file) {
		int read = 0;
		try(FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				DataInputStream dis = new DataInputStream(bis)) {
			read = dis.readInt();
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		return read;
	}
	public static int[] readArrInteger(String file) {
		StringBuilder sb = new StringBuilder();
		try(FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				DataInputStream dis = new DataInputStream(bis)) {
			while(dis.available() != 0) {
				sb.append(dis.readInt());
				sb.append("#");
			}
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		String[] tmp = sb.toString().split("#");
		int[] read = new int[tmp.length];
		int i = 0;
		for(String s : tmp) {
			read[i++] = Integer.valueOf(s);
		}
		return read;
	}
	public static int[] readArrInteger(File file) {
		StringBuilder sb = new StringBuilder();
		try(FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				DataInputStream dis = new DataInputStream(bis)) {
			while(dis.available() != 0) {
				sb.append(dis.readInt());
				sb.append("#");
			}
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		String[] tmp = sb.toString().split("#");
		int[] read = new int[tmp.length];
		int i = 0;
		for(String s : tmp) {
			read[i++] = Integer.valueOf(s);
		}
		return read;
	}
	public static double readDouble(String file) {
		double read = 0;
		try(FileInputStream fis = new FileInputStream(file);
				DataInputStream dis = new DataInputStream(fis)) {
			read = dis.readDouble();
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		return read;
	}
	public static double readDouble(File file) {
		double read = 0;
		try(FileInputStream fis = new FileInputStream(file);
				DataInputStream dis = new DataInputStream(fis)) {
			read = dis.readDouble();
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		return read;
	}
	public static void writeInteger(String file, int[] arr) {
		try(FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				DataOutputStream dos = new DataOutputStream(bos)) {
			for(int i : arr) {
				dos.writeInt(i);
			}
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static void writeInteger(File file, int[] arr) {
		try(FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				DataOutputStream dos = new DataOutputStream(bos)) {
			for(int i : arr) {
				dos.writeInt(i);
			}
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static String readUTF(String file) {
		String read = "";
		try(FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				DataInputStream dis = new DataInputStream(bis)) {
			read = dis.readUTF();
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		return read;
	}
	public static String readUTF(File file) {
		String read = "";
		try(FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				DataInputStream dis = new DataInputStream(bis)) {
			read = dis.readUTF();
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		return read;
	}
	public static void writeUTF(String file, String write) {
		try(FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				DataOutputStream dos = new DataOutputStream(bos)) {
			dos.writeUTF(write);
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static void writeUTF(File file, String write) {
		try(FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				DataOutputStream dos = new DataOutputStream(bos)) {
			dos.writeUTF(write);
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
}
