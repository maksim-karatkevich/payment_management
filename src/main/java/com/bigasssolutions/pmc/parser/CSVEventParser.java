package com.bigasssolutions.pmc.parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.bigasssolutions.pmc.model.Event;
import com.bigasssolutions.pmc.model.Shop;

/**
 * Created by Maksim_Karatkevich on 11/16/2017.
 */
public class CSVEventParser {
	private static List<Event> parse(File file) throws FileNotFoundException, ParseException {
		Scanner scanner = new Scanner(file);
		List<Event> result = new ArrayList<Event>();
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			if (s.matches("^\\d\\d\\.\\d\\d\\.\\d\\d\\d\\d.*") && !s.contains("Поступление на контракт клиента")) {
				result.add(createEvent(s));
			}
		}
		return result;
	}

	public static Event createEvent(String line) throws ParseException {
		Event event = new Event();
		String[] values = line.split(";");
		String date = values[0];
		DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		Date eventDate = df.parse(date);
		event.setDate(eventDate);
		event.setShop(new Shop(values[1].trim()));
		event.setSum(Double.parseDouble(values[2].replace(",", ".")));
		return event;
	}

	public static void convert(String inFile, String outFile, String from,
			String to)     //encoding of output file (e.g. UTF-8/windows-1251, etc)
			throws IOException, UnsupportedEncodingException {
		// set up byte streams
		InputStream in;
		if (inFile != null)
			in = new FileInputStream(inFile);
		else
			in = System.in;
		OutputStream out;
		if (outFile != null)
			out = new FileOutputStream(outFile);
		else
			out = System.out;

		if (from == null)
			from = System.getProperty("file.encoding");
		if (to == null)
			to = System.getProperty("file.encoding");

		// Set up character stream
		Reader r = new BufferedReader(new InputStreamReader(in, from));
		Writer w = new BufferedWriter(new OutputStreamWriter(out, to));
		char[] buffer = new char[4096];
		int len;
		while ((len = r.read(buffer)) != -1)
			w.write(buffer, 0, len);
		r.close();
		w.flush();
		w.close();
	}
}
