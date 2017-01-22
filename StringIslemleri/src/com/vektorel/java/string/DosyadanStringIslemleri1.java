package com.vektorel.java.string;

import java.io.File;
import java.util.Scanner;

public class DosyadanStringIslemleri1 {
	
	static String fileSeparator = System.getProperty("file.separator");

	public static void main(String[] args) {
		String metin = dosyaOku();
		
		String[] satirlar = metin.split("#");
		
		for (int i = 0; i < satirlar.length; i++) {
			String[] kelimeler = satirlar[i].split("@");

			System.out.println("\n----------------------------------------");
			
			System.out.println("Hasta No: " + kelimeler[1].split(":")[1]);
			System.out.println("Adý Soyadý: " + kelimeler[2].split(":")[1]);
			System.out.println("Yaþý: " + kelimeler[3].split(":")[1]);
			System.out.println("HBG: " + kelimeler[4].split(":")[1]);
			System.out.println("AG: " + kelimeler[5].split(":")[1]);
			
			System.out.println("----------------------------------------");
		}
	}
	
	private static String dosyaOku() {
		String icerik = "";
		try {
			File file = new File(System.getProperty("user.dir")+ fileSeparator +"metin.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				icerik += scanner.nextLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return icerik;
	}

}
