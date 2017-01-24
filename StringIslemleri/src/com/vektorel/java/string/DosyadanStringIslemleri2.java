package com.vektorel.java.string;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class DosyadanStringIslemleri2 {
	
	static String dosyaAyraci = System.getProperty("file.separator");
	static String satirAyraci = System.getProperty("line.separator");
	static String dosyaYolu = System.getProperty("user.dir");

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {

			System.out.println("===================");
			System.out.println("Menü:");
			System.out.println("1. Dosyadan Verileri Oku");
			System.out.println("2. Dosyaya Veri Ekle");
			System.out.println("0. Çýkýþ");
			System.out.println("===================");
int menu = scanner.nextInt();

			switch (menu) {
			case 1:
				verileriAyristir();
				break;
			case 2:
				dosyayaVeriEkle();
				break;
			case 0:
				return;

			default:
				break;
			}

		}	
}
	
	private static void verileriAyristir() {
		
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
		
		File file = new File(dosyaYolu + dosyaAyraci +"metin2.txt");
	
		try(FileInputStream fis = new FileInputStream(file)) {

			byte[] buffer = new byte[1024];
						
			while(fis.available() > 0) {

				int read = fis.read(buffer);
				
				icerik = new String(buffer, 0, read);
			}
		}
		catch (Exception e) {
		}

		return icerik;
	}
	
	private static void dosyayaVeriEkle() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Hasta No: ");
		String hastaNo = scanner.nextLine();
		
		System.out.print("Adý Soyadý: ");
		String hastaAdiSoyadi = scanner.nextLine();
		
		System.out.print("Yaþý: ");
		String hastaYasi = scanner.nextLine();
		
		System.out.print("HBG: ");
		String hastaHBG = scanner.nextLine();
		
		System.out.print("AG: ");
		String hastaAG = scanner.nextLine();
		
		try {
			File file = new File(dosyaYolu + dosyaAyraci +"metin2.txt");

			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileOutputStream fileOutputStream = new FileOutputStream(file, true);
			String metin = satirAyraci + "@PatNo:" + hastaNo + "@Pat:" + hastaAdiSoyadi + "@Age:" + hastaYasi + "@HBG:" + hastaHBG + "@AG:" + hastaAG + "@#";			
			
			fileOutputStream.write(metin.getBytes());
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

