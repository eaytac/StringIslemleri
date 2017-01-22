package com.vektorel.java.string;

public class StringIslemleri {

	public static void main(String[] args) {
		final String metin = 
			"@PatNo:234562@Pat:Taner TEMEL@Age:45@HBG:23@AG:45@#" +
			"@PatNo:234563@Pat:Kemal TEMEL@Age:34@HBG:23@AG:45@#" +
			"@PatNo:234564@Pat:Cemal TEMEL@Age:23@HBG:23@AG:45@#" + 
			"@PatNo:234565@Pat:Ay�e TEMEL@Age:5@HBG:23@AG:45@#  " +
			"@PatNo:234566@Pat:Fatma TEMEL@Age:75@HBG:23@AG:45@#" +
			"@PatNo:234562@Pat:Taner TEMEL@Age:45@HBG:23@AG:45@#" +
			"@PatNo:234563@Pat:Kemal TEMEL@Age:34@HBG:23@AG:45@#" +
			"@PatNo:234565@Pat:Ay�e TEMEL@Age:5@HBG:23@AG:45@#  " +
			"@PatNo:234566@Pat:Fatma TEMEL@Age:75@HBG:23@AG:45@#";
		
	
		String[] satirlar = metin.split("#");
		
		for (int i = 0; i < satirlar.length; i++) {
			String[] kelimeler = satirlar[i].split("@");

			System.out.println("\n----------------------------------------");
			
			System.out.println("Hasta No: " + kelimeler[1].split(":")[1]);
			System.out.println("Ad� Soyad�: " + kelimeler[2].split(":")[1]);
			System.out.println("Ya��: " + kelimeler[3].split(":")[1]);
			System.out.println("HBG: " + kelimeler[4].split(":")[1]);
			System.out.println("AG: " + kelimeler[5].split(":")[1]);
			
			System.out.println("----------------------------------------");
		}
		
		
	
	}
	

}