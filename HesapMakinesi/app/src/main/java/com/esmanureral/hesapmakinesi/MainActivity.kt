package com.esmanureral.hesapmakinesi

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.esmanureral.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

   // var birinciSayi:Double?=null
    //var ikinciSayi:Double?=null
    //var sonuc:Double?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
    fun hesapla(view: View){
        val birinciSayi = binding.editText1.text.toString().toDoubleOrNull()
        val ikinciSayi = binding.editText2.text.toString().toDoubleOrNull()

        if (birinciSayi == null || ikinciSayi == null) {
            binding.textView.text = "Numaraları giriniz!"
            return
        }
        val sonuc = when (view.id) {
            R.id.toplama -> birinciSayi + ikinciSayi
            R.id.Cikarma -> birinciSayi - ikinciSayi
            R.id.Carpma -> birinciSayi * ikinciSayi
            R.id.Bolme -> if (ikinciSayi != 0.0) birinciSayi / ikinciSayi else null
            else -> null
        }

        binding.textView.text = if (sonuc != null) "Sonuç: $sonuc" else "Sıfıra bölünemez!"
    }
}
   /* fun Toplama(view: View){
        birinciSayi=binding.editText1.text.toString().toDoubleOrNull()
        ikinciSayi=binding.editText2.text.toString().toDoubleOrNull()
        if(birinciSayi!=null && ikinciSayi!=null){
            sonuc=birinciSayi!!+ikinciSayi!!
            binding.textView.text="Sonuc: ${sonuc}"
        }
        else{
            binding.textView.text="Numaraları giriniz!"
        }
    }    fun Cikarma(view: View){
        birinciSayi=binding.editText1.text.toString().toDoubleOrNull()
        ikinciSayi=binding.editText2.text.toString().toDoubleOrNull()
        if(birinciSayi!=null && ikinciSayi!=null){
            sonuc=birinciSayi!!-ikinciSayi!!
            binding.textView.text="Sonuc: ${sonuc}"
        }
        else{
            binding.textView.text="Numaraları giriniz!"
        }
    } fun Bolme(view: View){
        birinciSayi=binding.editText1.text.toString().toDoubleOrNull()
        ikinciSayi=binding.editText2.text.toString().toDoubleOrNull()
        if(birinciSayi!=null && ikinciSayi!=null){
            sonuc=birinciSayi!!/ikinciSayi!!
            binding.textView.text="Sonuc: ${sonuc}"
        }
        else{
            binding.textView.text="Numaraları giriniz!"
        }
    }
    fun Carpma(view: View){
        val birinciSayi=binding.editText1.text.toString().toDoubleOrNull()
        val ikinciSayi=binding.editText2.text.toString().toDoubleOrNull()

        if(birinciSayi!=null && ikinciSayi!=null){
            val sonuc=(birinciSayi*ikinciSayi)
            binding.textView.text="Sonuc: ${sonuc}"
        }
*/



