package com.eulerity.hackathon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class LogoFinder {

	/**
	 * Given a business's URL, returns a URL pointing to the logo of the business
	 * 
	 * You can use third party APIs as long as they don't provide a direct solution to the problem.
	 *
	 * For example, you can use Yelp's Fusion API to find business details, but you can not use an API 
	 * which takes a URL (or domain) and returns a logo image.
	 * 
	 * Feel free to create any packages or classes you'd like. Additionally, you can import any open source
	 * libraries you like.
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
	 *
	 *  1 - Follow the output file naming convention
	 *  2 - Output a reasonably valid HTML file so we can review your work.
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
		writer.write(HTML_HEAD);
		String line;
		while ((line = reader.readLine()) != null) {
			String url = line.trim();
			String resolved;
			try {
				resolved = findLogoUrl(url);
			} catch (Exception e) {
				resolved = "Error:" + e.getMessage();
			}

			writer.write(String.format(ROW_FMT, url, resolved, resolved));
		}
		writer.write(HTML_TAIL);
		reader.close();
		writer.close();
		System.out.println(String.format("\n\nGenerated file:\n\n%s\n\n", outputFilename));
	}
	
	private static final String ROW_FMT = "<tr><td>%s</td><td>%s</td><td><img src=\"%s\"></td></tr>";
	
	private static final String HTML_HEAD = "<html><head></head><body>\n" + 
			"<table>\n" + 
			"<thead><tr><th>Business URL</th><th>Logo URL</th><th>Logo</th></tr></thead>\n" + 
			"<tbody>";

	private static final String HTML_TAIL = "</tbody></body></html>";
}
