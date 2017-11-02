package com.eulerity.hackathon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class LogoFinder {

	/**
	 * Given a business's URL, returns a URL pointing to the logo of the business
	 *  
	 * @param url of business's site
	 * @return url of business's logo
	 * @throws Exception
	 */
	public static String findLogoUrl(String url) throws Exception {

		//
		//   YOUR CODE HERE!
		//
		//
		
		return url + "/logo.png";
	}
	
	
	/**
	 * Prefer to not edit this method.
	 *
	 * The only rules here are that you:
	 *  1 - follow the file naming convention
	 *  2 - Output a reasonably valid HTML file so we can review your work.
	 * 
	 *
	 */
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			throw new Exception("Please provide an input file.");
		}
		String inputFilename = args[0];
		String outputFilename = String.format("%s_%d_output.html", inputFilename, System.currentTimeMillis());
		BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename));
		writer.write("<html><head></head><body>");
		String line;
		while ((line = reader.readLine()) != null) {
			String url = line.trim();
			String resolved;
			try {
				resolved = String.format("<img src=\"%s\">", findLogoUrl(url));
			} catch (Exception e) {
				resolved = "Error:" + e.getMessage();
			}

			writer.write(String.format("<p>%s %s</p>\n", url, resolved));
		}
		writer.write("</body></html>");
		reader.close();
		writer.close();
		System.out.println("Generated file:" + outputFilename);
	}

}
