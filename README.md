Cara Clone Repository dari GitHub ke Android Studio
Dokumentasi ini berisi langkah-langkah untuk meng-clone repository dari GitHub dan membukanya di Android Studio.

Prasyarat
Pastikan perangkat Anda memiliki:
- Android Studio yang sudah terinstall
- Akun GitHub yang sudah aktif
- Git yang sudah terinstall (biasanya sudah terpasang jika Anda menginstal Android Studio)

Langkah-langkah Clone Repository
1. Buka Android Studio: Pastikan Anda berada di halaman awal Android Studio atau keluar dari proyek yang sedang dibuka.
   
3. Pilih Opsi Get from VCS:
   - Pada halaman utama Android Studio, klik Get from Version Control. Jika   Anda tidak menemukan opsi ini, Anda dapat menemukannya di menu File > New > Project from Version Control.
    
3. Masukkan URL Repository GitHub:
   - Buka repository GitHub yang ingin Anda clone.
   - Klik tombol Code berwarna hijau, lalu salin URL repository (https://github.com/VioniWijaya/ESL).
   - Tempel URL tersebut ke kolom URL di Android Studio.
  
4. Tentukan Direktori Proyek:
   - Android Studio akan secara otomatis menyarankan lokasi folder tempat proyek akan disimpan. Anda bisa mengganti direktori jika diinginkan.

5. Klik Tombol Clone:
   - Setelah menempelkan URL dan memilih direktori, klik tombol Clone.
   - Android Studio akan mulai mengunduh file repository dari GitHub ke komputer Anda.

6. Masuk atau Verifikasi Akun GitHub (Jika Diminta):
   - Jika Anda belum login atau belum menambahkan akun GitHub di Android Studio, Anda akan diminta untuk masuk menggunakan GitHub
   - Masukkan kredensial akun GitHub Anda atau login melalui browser jika diminta.
     
7. Buka Proyek:
   - Setelah proses clone selesai, Android Studio akan membuka proyek secara otomatis
   - Tunggu hingga Android Studio selesai melakukan sinkronisasi dependensi dan mengunduh file yang diperlukan (seperti file gradle, library, dll).

8. Run dan Periksa Proyek:
   - Setelah semua sinkronisasi selesai, Anda dapat menjalankan proyek di emulator atau perangkat fisik untuk memverifikasi bahwa proyek berhasil di-clone dengan benar.
     
Troubleshooting
- Jika mengalami masalah saat clone, periksa koneksi internet Anda dan pastikan Git sudah terinstall di sistem.
- Jika diminta autentikasi GitHub berulang kali, pastikan kredensial sudah tersimpan dengan benar di Android Studio.
  
Catatan:
Jangan lupa untuk melakukan Pull secara berkala untuk mendapatkan perubahan terbaru dari repository.
