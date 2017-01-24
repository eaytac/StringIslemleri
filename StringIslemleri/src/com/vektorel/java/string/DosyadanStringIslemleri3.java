package com.vektorel.java.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DosyadanStringIslemleri3 {
	
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
		String icerik = "", satir = "";
		
		File file = new File(dosyaYolu + dosyaAyraci +"metin3.txt");
		
		try {
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((satir = bufferedReader.readLine()) != null) {
            	icerik += satir;
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Dosya açýlamýyor: '" + file + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Dosya okunmasýnda hata: '" + file + "'");                  
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
			 	File file = new File(dosyaYolu + dosyaAyraci +"metin3.txt");
			 	
				if (!file.exists()) {
					file.createNewFile();
				}
			 	
			 	FileWriter fileWriter = new FileWriter(file, true);

	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	            
	            String metin = satirAyraci + "@PatNo:" + hastaNo + "@Pat:" + hastaAdiSoyadi + "@Age:" + hastaYasi + "@HBG:" + hastaHBG + "@AG:" + hastaAG + "@#";
	            
	            bufferedWriter.write(metin);

	            bufferedWriter.close();
	        }
	        catch(IOException ex) {
	            ex.printStackTrace();
	        }
	
	}

}

