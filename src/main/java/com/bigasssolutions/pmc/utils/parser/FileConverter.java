package com.bigasssolutions.pmc.utils.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class FileConverter {

	private final static String RESULT_PATH = "src\\main\\resources\\result.txt";
	private final static String FROM_ENCODING = "windows-1251";
	private final static String TO_ENCODING = "UTF-8";

	public static void convert(String inFile) throws IOException {
		InputStream in;
		if (inFile != null)
			in = new FileInputStream(inFile);
		else
			in = System.in;
		OutputStream out;
		if (RESULT_PATH != null)
			out = new FileOutputStream(RESULT_PATH);
		else
			out = System.out;

		// Set up character stream
		Reader r = new BufferedReader(new InputStreamReader(in, FROM_ENCODING));
		Writer w = new BufferedWriter(new OutputStreamWriter(out, TO_ENCODING));
		char[] buffer = new char[4096];
		int len;
		while ((len = r.read(buffer)) != -1)
			w.write(buffer, 0, len);
		r.close();
		w.flush();
		w.close();
	}
}
