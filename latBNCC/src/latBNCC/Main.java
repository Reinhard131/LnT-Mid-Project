package latBNCC;

import java.util.Scanner;
import java.util.Vector;

public class Main {

	Vector<String> kodeK = new Vector<>();
	Vector<String> namaK = new Vector<>();
	Vector<String> jenisK = new Vector<>();
	Vector<String> jabatanK = new Vector<>();
	Vector<Integer> gajiK = new Vector<>();
	Scanner scan = new Scanner(System.in);
	int jumlahM, jumlahS, jumlahA = 0;

 public void kenaikanGaji(String jabatan) {
	double naikGaji = jabatan.equals("Manager")? 0.1 : jabatan.equals("Supervisor")? 0.075 : 0.05;
	  for (int i = 0; i < kodeK.size()-1; i++) {
		  if(jabatanK.get(i).equals(jabatan)) {
			  int x = gajiK.get(i);
			  gajiK.set(i, (int) (x + (x * naikGaji)));
		  }
	  }
 }

 public void input() {
	 String id, nama, jenis, jabatan;
	 int gaji;
	 boolean telahAda, pegawaiLebih;

  do {
   telahAda = false;
   int hurufPertama = (int) ((Math.random() * (90-65)) + 65);
   int hurufKedua = (int) ((Math.random() * (90-65)) + 65);
   int angka = (int) ((Math.random() * (9999-1000)) + 1000);
   id = String.format("%c%c-%d", hurufPertama, hurufKedua, angka);
   for (String string : kodeK) {
    if (id.equals(string)) {
     telahAda = true;
    }
   }

  } while (telahAda = false);

  do {
   System.out.print("Input nama karyawan [>= 3] : ");
   nama = scan.nextLine();
  } while (nama.length()<3);

  do {
   System.out.print("Input jenis kelamin [Laki-Laki | Perempuan] (Case Sensitive) : ");
   jenis = scan.nextLine();
  } while (!jenis.equals("Laki-Laki") && !jenis.equals("Perempuan"));

  do {
   System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive) : ");
   jabatan = scan.nextLine();
  } while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));

  gaji = jabatan.equals("Manager")? 8000000 : jabatan.equals("Supervisor")? 6000000 : 4000000;

  kodeK.add(id);
  namaK.add(nama);
  jenisK.add(jenis);
  jabatanK.add(jabatan);
  gajiK.add(gaji);

  if(gaji == 8000000) {
   jumlahM++;
   if(jumlahM > 3) {
    kenaikanGaji("Manager");
   }
  }
  else if(gaji == 6000000) {
   jumlahS++;
   if(jumlahS > 3) {
    kenaikanGaji("Supervisor");
   }
  }
  else {
   jumlahA++;
   if(jumlahA > 3) {
    kenaikanGaji("Admin");
   }
  }

  System.out.println("Data successfully added!\nPress enter to continue...");
  scan.nextLine();
  menu();
 }

 public void view() {
  if(namaK.size() == 0) {
   System.out.println("No data!");
   menu();
  }
  else {
   for (int i = 0; i < namaK.size(); i++) {
    for (int j = 0; j < namaK.size() - i - 1; j++) {
    if(namaK.get(j).compareTo(namaK.get(j+1)) > 0) {
     String temp = namaK.get(j+1);
     namaK.set(j+1, namaK.get(j));
     namaK.set(j, temp);

     temp = kodeK.get(j+1);
     kodeK.set(j+1, kodeK.get(j));
     kodeK.set(j, temp);

     temp = jenisK.get(j+1);
     jenisK.set(j+1, jenisK.get(j));
     jenisK.set(j, temp);

     temp = jabatanK.get(j+1);
     jabatanK.set(j+1, jabatanK.get(j));
     jabatanK.set(j, temp);

     int tempD = gajiK.get(j+1);
     gajiK.set(j+1, gajiK.get(j));
     gajiK.set(j, tempD);
    }
   }
  }
   System.out.println("|----|---------------"
     + "|------------------------------"
     + "|---------------|---------------"
     + "|---------------|");
   System.out.printf("|%-4s|%-15s|%-30s|%-15s|%-15s|%15s|\n", "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
   System.out.println("|----|---------------"
     + "|------------------------------"
     + "|---------------|---------------"
     + "|---------------|");

   for (int i = 0; i < namaK.size(); i++) {
   System.out.printf("|%4d|%15s|%30s|%15s|%15s|%15d|\n", (i+1), kodeK.get(i), namaK.get(i), jenisK.get(i), jabatanK.get(i), gajiK.get(i));
  }
   System.out.println("|----|---------------"
     + "|------------------------------"
     + "|---------------|---------------"
     + "|---------------|");
  }
 }

 public void update() {
	 view();
	 int cho;
	 do {
		 System.out.print("Input nomor urutan karyawan yang ingin diupdate : ");
		 cho = scan.nextInt(); scan.nextLine();
	 } while (cho < 0 || cho > namaK.size());
	 cho--;
	 String id, nama, jenis, jabatan;
	 int gaji;
	 boolean telahAda;

	 do {
		 telahAda = false;
		 int hurufPertama = (int) ((Math.random() * (90-65)) + 65);
		 int hurufKedua = (int) ((Math.random() * (90-65)) + 65);
		 int angka = (int) ((Math.random() * (9999-1000)) + 1000);
		 id = String.format("%c%c-%d", hurufPertama, hurufKedua, angka);
		 for (String string : kodeK) {
	     if (id.equals(string)) {
	    	 telahAda = true;
	    	 }
	    }
	} while (telahAda = false);

	do {
		System.out.print("Input nama karyawan [>= 3] : ");
	    nama = scan.nextLine();
	   } while (nama.length()<3);

	   do {
	    System.out.print("Input jenis kelamin [Laki-Laki | Perempuan] (Case Sensitive) : ");
	    jenis = scan.nextLine();
	   } while (!jenis.equals("Laki-Laki") && !jenis.equals("Perempuan"));

	   do {
	    System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive) : ");
	    jabatan = scan.nextLine();
	   } while (!jabatan.equals("Manager") && !jabatan.equals("Supervisor") && !jabatan.equals("Admin"));

	   gaji = jabatan.equals("Manager")? 8000000 : jabatan.equals("Supervisor")? 6000000 : 4000000;

	   kodeK.set(cho, id);
	   namaK.set(cho, nama);
	   jenisK.set(cho, jenis);
	   jabatanK.set(cho, jabatan);
	   gajiK.set(cho, gaji);

	   System.out.println("Data successfully added!\nPress enter to continue...");
	   scan.nextLine();
	   menu();
 }

 public void delete() {
	 view();
	 int cho;
	 do {
		 System.out.print("Input nomor urutan karyawan yang ingin hapus : ");
		 cho = scan.nextInt(); scan.nextLine();
	 }
	 while (cho < 0 || cho > namaK.size());
	 cho--;

	 String kode = kodeK.get(cho);
	 String jabatan = jabatanK.get(cho);

	 if(jabatan.equals("Manager")) jumlahM--;
	 else if(jabatan.equals("Supervisor")) jumlahS--;
	 else jumlahA--;

	 kodeK.remove(cho);
	 namaK.remove(cho);
	 jenisK.remove(cho);
	 jabatanK.remove(cho);
	 gajiK.remove(cho);

	 System.out.println("Karyawan dengan kode " +kode+ " berhasil dihapus\nPress enter to continue...");
	 scan.nextLine();
	 menu();
 }

 public void menu() {
  System.out.println("PT Meksiko\r\n"
    + "==========\r\n"
    + "1. Insert data karyawan\r\n"
    + "2. View data karyawan\r\n"
    + "3. Update data karyawan\r\n"
    + "4. Delete data karyawan\r\n"
    + "5. Exit");

  int cho;
  do {
   System.out.print(">> ");
   cho = scan.nextInt(); scan.nextLine();
  } while (cho < 1 || cho > 5);

  switch(cho) {
  case 1:
   input();
   break;
  case 2:
   view();
   System.out.println("Press enter to continue...");
   scan.nextLine();
   menu();
   break;
  case 3:
   update();
   break;
  case 4:
   delete();
   break;
  case 5:
   System.exit(0);
   break;
  }
 }
 public Main() {
  menu();
 }

 public static void main(String[] args) {
  new Main();
 }
}