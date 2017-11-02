package com.eulerity.hackathon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			throw new Exception("Please provide an input file.");
		}
		String inputFilename = args[0];
		String outputFilename = String.format("%s_%d_output.tsv", inputFilename, System.currentTimeMillis());
		BufferedReader reader = new BufferedReader(new FileReader(inputFilename));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename));
		String line;
		while ((line = reader.readLine()) != null) {
			String url = line.trim();
			writer.write(url);
			writer.write("\t");
			try {
				writer.write(findLogoUrl(url));
			} catch (Exception e) {
				writer.write("Error:" + e.getMessage());
			}
			writer.write("\n");
		}
		reader.close();
		writer.close();
		System.out.println("Generated file:" + outputFilename);
	}
	
	public static String findLogoUrl(String url) {
		// Your code here
		return url + "/logo.png";
	}

}
