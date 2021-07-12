package io_tools;

import java.util.Formatter;
import java.util.regex.Pattern;
import java.io.*;

public class ToolTextFile {
	public static String read(String file) {
		StringBuilder sb = new StringBuilder();
		try(FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr)) {
			String tmp = "";
			while((tmp = br.readLine()) != null) {
				sb.append(tmp);
			}
		} catch (IOException exc) {
			exc.printStackTrace();
		}
		return sb.toString();
	}
	public static String read(File file) {
		StringBuilder sb = new StringBuilder();
		try(FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr)) {
			String tmp = "";
			while((tmp = br.readLine()) != null) {
				sb.append(tmp);
			}
		} catch (IOException exc) {
			exc.printStackTrace();
		}
		return sb.toString();
	}
	public static String read(String file, Pattern splitter) {
		StringBuilder sb = new StringBuilder();
		sb.append(read(file).split(splitter.pattern()));
		return sb.toString();
	}
	public static String read(File file, Pattern splitter) {
		StringBuilder sb = new StringBuilder();
		sb.append(read(file).split(splitter.pattern()));
		return sb.toString();
	}
	public static void write(String file, String write) {
		try(PrintWriter pw = new PrintWriter(file)) {
			pw.println(write);
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static void write(File file, String write) {
		try(PrintWriter pw = new PrintWriter(file)) {
			pw.println(write);
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static void writef(String file, String write, Formatter format) {
		try(FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw)) {
			pw.printf(format.toString(), write);
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static void writef(File file, String write, Formatter format) {
		try(FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw)) {
			pw.printf(format.toString(), write);
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static void write(String file, String[] write) {
		try(PrintWriter pw = new PrintWriter(file)) {
			pw.println(write);
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static void write(File file, String[] write) {
		try(PrintWriter pw = new PrintWriter(file)) {
			pw.println(write);
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static void writef(String file, String[] write, Formatter format) {
		try(FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw)) {
			for(String out : write) {
				pw.printf(format.toString(), out);
			}
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	public static void writef(File file, String[] write, Formatter format) {
		try(FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw)) {
			for(String out : write) {
				pw.printf(format.toString(), out);
			}
		} catch(IOException exc) {
			exc.printStackTrace();
		}
	}
}
