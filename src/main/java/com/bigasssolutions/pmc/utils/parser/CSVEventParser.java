package com.bigasssolutions.pmc.utils.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	public static List<Event> parse(String path) throws FileNotFoundException, ParseException {
		try {
			FileConverter.convert(path);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(new File("src\\main\\resources\\result.txt"));
		List<Event> result = new ArrayList<Event>();
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			if (s.matches("^\\d\\d\\.\\d\\d\\.\\d\\d\\d\\d.*") && !s.contains("Поступление на контракт клиента")) {
				result.add(createEvent(s));
			}
		}
		return result;
	}

	private static Event createEvent(String line) throws ParseException {
		Event event = new Event();
		String[] values = line.split(";");
		String date = values[0];
		DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		Date eventDate = df.parse(date);
		event.setDate(eventDate);
		event.setShop(new Shop(values[1].trim().replace("\"","")));
		event.setSum(Double.parseDouble(values[2].replace(",", ".")));
		return event;
	}


}
