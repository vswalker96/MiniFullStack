package com.revature.minifullstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TimeInWordsService {

	
	public String timeInWords(int h, int m) {
		String[] numNames = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
				"twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twnety six",
				"twenty seven", "twenty eight", "twenty nine" };

		String timeInWords = "";

		if (m == 0) {
			timeInWords = numNames[h] + " o' clock ";
		} else if (m == 30) {
			timeInWords = "half past " + numNames[h];
		} else if (m == 15) {
			timeInWords = "quarter past " + numNames[h];
		} else if (m == 45) {
			timeInWords = "quarter to " + numNames[h + 1];
		} else if (m == 1) {
			timeInWords = "one minute past " + numNames[h];
		} else if (m == 10) {
			timeInWords = "ten minutes past " + numNames[h];
		} else if (m == 40) {
			timeInWords = "fourty minutes past " + numNames[h + 1];
		} else if (m <= 30) {
			timeInWords = numNames[m] + " minutes past " + numNames[h];
		} else if (m >= 30) {
			timeInWords = numNames[60 - m] + " minutes to " + numNames[h + 1];

		}

		return timeInWords;

	}
}
