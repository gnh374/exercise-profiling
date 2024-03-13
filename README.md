## Refleksi

#### 1.  What is the difference between the approach of performance testing with JMeter and profiling with IntelliJ Profiler in the context of optimizing application performance?

- Perfomance testing dengan JMeter digunakan untuk mengetahuui rekasi aplikasi terhadap beban kerja yang tinggi. Karena itu, JMeter akan mensimulasikan jumlah pengguna yang besar untuk melihat bagaimana aplikasi merespons. Hasil dari performance testing ini membantu dalam mengidentifikasi titik lemah aplikasi dan mengukur kinerja aplikasi dalam situasi beban yang tinggi.
- Profiling dengan IntelliJ Profiler digunakan untuk menganalisis kinerja aplikasi secara mendalam dengan melihat bagaimana aplikasi menggunakan sumber daya seperti CPU, memori, dan IO. IntelliJ Profiler membantu mengidentifikasi bagian-bagian kode yang memakan waktu atau sumber daya secara berlebihan, sehingga memungkinkan pengembang untuk mengoptimalkan kode tersebut.


#### 2. How does the profiling process help you in identifying and understanding the weak points in your application?

- Profiling akan memberikan informasi detail bagaimana aplikasi menggunakan sumber daya, seperti CPU, memory, dan IO. Profiling akan menunjukkan bagian mana dari code yang memakan sumber daya terbesar , misalnya yang membutuhkan waktu eksekusi yang lama atau yang memakan banyak memori. 

#### 3. Do you think IntelliJ Profiler is effective in assisting you to analyze and identify bottlenecks in your application code?

- Ya, dengan memberikan informasi mengenai bagian code mana yang menggunakan sumber daya yang besar, saya jadi tahu bottlenecks dari aplikasi saya dan bisa fokus untuk mengoptimalkan bagian tersebut


#### 4. What are the main challenges you face when conducting performance testing and profiling, and how do you overcome these challenges?

- Tantangannya adalah saya harus bisa memahami apa yang direpresentasikan oleh JMeter dan Intelij Profiler untuk bisa menganalisis code saya dan itu cukup sulit.


#### 5. What are the main benefits you gain from using IntelliJ Profiler for profiling your application code?
- Keuntungannya adalah saya jadi bisa memahami code saya dengan lebih mendalam. Dengan menggunakan Inteli Profiler, saya jadi bisa tahu bagian spesifik dari code saya yang menggunakan banyak resouce atau memakan waktu eksekusi yang banyak (tidak hanya waktu eksekusi keseluruhan program) sehingga saya bisa fokus untuk mengoptimalkan bagian tersebut/ Selain itu, saya juga jadi tidak perlu menggunakan software lain untuk melakukan analisis ini, karena Intelij Profiler sudah tersedia di Intelij Idea (IDE yang saya gunakan)

#### 6. How do you handle situations where the results from profiling with Inte	lliJ Profiler are not entirely consistent with findings from performance testing using JMeter?

- Jika saya mengalami hal ini, hal pertama yang akan saaya lakukan adalah mengecek waktu dan environment saat kedua software ini bekerja karena bisa jadi hal ini yang menyebabkan perbedaan hasil. Jika setelah memastikan hal ini hasilnya masih berbeda, saya akan meninjau ulang hasil dari kedua software untuk melihat apakah ada perbedaan yang jelas atau apakah mereka mengukur aspek yang berbeda dari kinerja aplikasi. Lalu saya juga akan melakukan pengecekan apakah ada korelasi antara temuan yang ditunjukkan oleh JMeter dan temuan oleh Intelij Profiler.

#### 7. What strategies do you implement in optimizing application code after analyzing results from performance testing and profiling? How do you ensure the changes you make do not affect the application's functionality?

- Mengurangi pembuatan objek yang tidak perlu

     Saat mengoptimalkan method ``` getAllStudentsWithCourses() ``` saya menghilangkan pembuatan objek ``` StudentCourse``` baru dan langsung memasukkan objek StudentCourse yang sudah ada ke dalam list akhir. Hal ini saya lakukan karena objek StudentCourse baru yang dibuat  identik sehingga menurut saya tidak perlu dibuat objek baru.
- Mengoptimalkan penggunaan memori dengan menggunakan Objek StringBuilder
    
    Saat mengoptimalkan method ```joinStudentNames()``` saya mengganti proses konkatenasi String biasa menjadi menggunakan ```StringBuilder```. Hal ini saya lakukan karena setiap kali kita melakukan konkatenasi pada String biasa, Java akan membuat objek String baru yang akan memakan memori. Dengan menggunakan StringBuilder, kita bisa melakukan operasi konkatenasi String tanpa membuat objek String baru sehingga lebih optimal dalam penggunaan memori.
- Optimisasi Query
  
    Saat mengoptimalkan method ```findStudentWithHighestGpa()```, saya mengubah proses yang awalnya mengambil semua data mahasiswa lalu baru mencari mahasiswa dengan GPA tertinggi dengan membandingkan melalui for loop, menjadi hanya mengambil 1 data mahasiswa dengan GPA tertinggi. Dengan demikian, proses mencari mahasiswa dengan GPA tertinggi dilakukan saat melakukan query dan program tidak perlu lagi melakukan logic untuk mencari mahasiswa dengan GPA tertinggi sehingga waktu eksekusi program menjadi lebih singkat.


Untuk memastikan bahwa output yang dihasilkan tetap sama setelah melakukan optimisasi, saya membandingkan output yang ada pada postman sebelum dan sesudah dilakukan optimisasi walaupun sebenarnya menerapkan unit-test akan lebih efektif.


## Report

### api ```/all-student```

Sebelum optimisasi
![before GUI](https://github.com/gnh374/exercise-profiling/assets/121223135/35ddf0c1-6dbe-45c0-bd00-8301aed102df)
![before CLI](https://github.com/gnh374/exercise-profiling/assets/121223135/e35b569b-db77-4aa0-861d-14f91d356574)

Setelah optimisasi
![After](https://github.com/gnh374/exercise-profiling/assets/121223135/eb03cd23-8585-4d6a-a9be-9ff57958229c)
Waktu eksekusi ```getAllStudentWithCourses()```
   
- Sebelum optimisasi (ms): 15,692
- Setelah optimisasi (ms): 5,915
- Persentase perbedaan: 62.31 %
- 
### api ```/highest-gpa```

Sebelum optimisasi
![before GUI](https://github.com/gnh374/exercise-profiling/assets/121223135/008b00a5-b454-4cd9-bdd6-8a377555539f)

![before CLI](https://github.com/gnh374/exercise-profiling/assets/121223135/ca6d83eb-c29a-40bb-b9b7-b00dffb7b6aa)

Setelah optimisasi
![After](https://github.com/gnh374/exercise-profiling/assets/121223135/a420f25a-5a26-4127-9424-6ee4d0218d68)

Waktu eksekusi ```findStudentWithHighestGpa()```

- Sebelum optimisasi (ms): 617
- Setelah optimisasi (ms): 12
- Persentase perbedaan: 98.06%


### api ```/all-student-name```

Sebelum optimisasi
![before GUI](https://github.com/gnh374/exercise-profiling/assets/121223135/f275fe75-359f-49e1-8e24-b113a2c6de53)

![before CLI](https://github.com/gnh374/exercise-profiling/assets/121223135/feed0d81-e33b-4a09-9915-4aa7c37abddf)

Setelah optimisasi
![After](https://github.com/gnh374/exercise-profiling/assets/121223135/fd0da4a8-b236-4971-ab62-2bd198b36729)


Waktu eksekusi ```joinStudentNames()```

- Sebelum optimisasi (ms): 1,555
- Setelah optimisasi (ms): 156
- Persentase perbedaan: 89.97 %
    



