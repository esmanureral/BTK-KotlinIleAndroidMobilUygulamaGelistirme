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
    </details>
    
## 4-FRAGMENTVENAVİGATİOM KLASÖRÜNDE NELER VAR?
<details>
  <summary>📌Fragment Ve Navigation Detayları İçin Tıklayınız.
    
  </summary>
  
Bu proje, Android'de Fragment Navigasyonu kullanımını ve verilerin fragmanlar arasında güvenli bir şekilde aktarılmasını gösteren bir örnektir. Navigation Component kullanılarak, Binding ve Safe Args özellikleriyle veri iletimi yapılmaktadır.

## Özellikler

- **Binding**: Fragment'lar arasında view'lara kolayca erişmek için `FragmentBirinciBinding` ve `FragmentIkinciBinding` kullanılmıştır.
- **Navigasyon**: Safe args kullanılarak veriler (örneğin, kullanıcı adı) bir fragmandan diğerine aktarılmaktadır.
- **Açık Ayrım**: Her fragment kendi sorumluluğuna sahip olup, düzeni ve işlevi ayrıdır.

## Çalışma Prensibi

Bu uygulama iki fragmandan oluşmaktadır:
1. **BirinciFragment**: Kullanıcı, bir `EditText` alanına adını yazıp bir düğmeye tıkladığında, ikinci fragmana geçer.
2. **IkinciFragment**: **BirinciFragment**'te girilen kullanıcı adı bir `TextView`'da görüntülenir.

### Akış:
1. **BirinciFragment**:
   - Kullanıcı adı `EditText` alanına girilir.
   - Kullanıcı, adı ile birlikte ikinci fragmana geçmek için butona tıkladığında, bu veri güvenli bir şekilde ikinci fragmana aktarılır.

2. **IkinciFragment**:
   - Gönderilen kullanıcı adı burada bir `TextView`'da görüntülenir.

## Kurulum

1. **Bağımlılıklar**:
   **Navigation** ve **View Binding** için gerekli bağımlılıkları `build.gradle` dosyasına ekleyin.

      </details>

