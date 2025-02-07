# BTK - KOTLİN İLE ANDROİD MOBİL UYGULAMA GELİŞTİRME TEMELLERİ

## 1- HESAPMAKİNESİ KLASÖRÜNDE NELER VAR?
<details>
  <summary>📌 Hesap Makinesi Detayları İçin Tıklayınız.
    
  </summary>


  Bu proje, **Kotlin** dili ile geliştirilen basit bir **Hesap Makinesi** uygulamasıdır.  
  Kullanıcıdan alınan iki sayı ile **toplama, çıkarma, çarpma ve bölme işlemleri** yapılabilir.

  ### 🚀 Özellikler
  - **View Binding Kullanımı**  
    - `ActivityMainBinding` ile temiz ve düzenli bir kod yazımı sağlandı.  
  - **Dört İşlem Yapabilme**  
    - Toplama (+), Çıkarma (-), Çarpma (*), Bölme (/)  
  - **Kullanıcı Hata Kontrolü**  
    - Boş giriş alanları için `"Numaraları giriniz!"` uyarısı  

  ### 📷 Ekran Görüntüsü
  | Hesap Makinesi Arayüzü |
  |------------------------|
  | ![Hesap Makinesi](https://via.placeholder.com/300x600) |

  ### 🛠 Kullanılan Teknolojiler
  - **Kotlin**
  - **Android Studio**
  - **View Binding**
</details>

## 2- SHAREDPREFERENCES KLASÖRÜNDE NELER VAR?
<details>
  <summary>📌 Shared Preferences Detayları İçin Tıklayınız.
    
  </summary>
  
  Bu proje, **Kotlin** dili ile geliştirilmiş olup, **SharedPreferences** kullanarak kullanıcı bilgisini saklama ve silme işlemlerini içerir.  
  Kullanıcı adı kaydedilip tekrar açıldığında ekranda gösterilebilir.
 
  ### 🚀 Özellikler
  - **SharedPreferences Kullanımı**
    - Kullanıcı adı kaydetme ve silme özellikleri
    - Veriler cihazda kalıcı olarak saklanır
  - **View Binding ile Kullanıcı Arayüzü Kontrolü**
  - **Hata Kontrolleri**
    - Boş giriş yapılırsa uyarı mesajı gösterilir
    </details>
    
## 3-RECYLERVİEW KLASÖRÜNDE NELER VAR?
<details>
  <summary>📌 Recyler View Detayları İçin Tıklayınız.
    
  </summary>
  
 Bu uygulama, RecyclerView kullanarak bir liste oluşturmayı ve bir öğeye tıkladığında o öğeyle ilgili detaylı bilgiye sahip yeni bir aktivite açmayı gösteren basit bir Android uygulamasıdır.

   ### 📷 Ekran Görüntüsü

  <p align="center">
  <img src="https://github.com/user-attachments/assets/3634676f-9f2a-4e63-bfc6-b59eb863b536" width="200">
  <img src="https://github.com/user-attachments/assets/94c43f2b-350c-4a9b-921c-aefde061c54e" width="200">
</p>

  
## Özellikler:
- **RecyclerView**: Uygulama, `RecyclerView` kullanarak dinamik bir liste görüntüler. Her bir öğe bir süper kahramanın adı ve mesleği hakkında bilgi sunar.
- **Intent**: Kullanıcı bir öğeye tıkladığında, `Intent` ile detaylı bilgilerin gösterileceği yeni bir aktivite açılır.
- **Serializable**: `SuperKahraman` sınıfı, `Serializable` arayüzünü implement ederek, RecyclerView öğesinin detayları arasında veri taşımayı mümkün kılar.
      </details>

