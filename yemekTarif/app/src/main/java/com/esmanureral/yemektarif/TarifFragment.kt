package com.esmanureral.yemektarif

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.esmanureral.yemektarif.databinding.FragmentListeBinding
import com.esmanureral.yemektarif.databinding.FragmentTarifBinding
import com.google.android.material.snackbar.Snackbar
import java.io.IOException

class TarifFragment : Fragment() {
    private var _binding: FragmentTarifBinding?=null
    private val binding get()=_binding!!
    private lateinit var permissionLauncher:ActivityResultLauncher<String>//izin istemek için
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>//galeriye gitmek için
    private var secilenGorsel: Uri? = null //kaynagımızın nerede oldugunu belirtir
    private var secilenBitmap: Bitmap? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerLauncher()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTarifBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.kaydetButton.setOnClickListener { kaydet(it) }
        binding.imageView.setOnClickListener{gorselSec(it)}
        binding.silButton.setOnClickListener { sil(it) }

        arguments?.let {
           val bilgi= TarifFragmentArgs.fromBundle(it).bilgi

            if(bilgi=="yeni"){//yeni tarif ekleniyorsa sil butonu tıklanmayacak
                binding.silButton.isEnabled=false
                binding.kaydetButton.isEnabled=true
            }
            else{
                binding.silButton.isEnabled=true
                binding.kaydetButton.isEnabled=false

            }
        }

    }

    fun kaydet(view: View){

    }
    fun sil(view: View){

    }
    fun gorselSec(view: View){

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU){

            //READ_EXTERNAL_STORAGE izinini var mı yok mu kontrol ediyoruz izin verilmediyse if içine giriyor.
            if(ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.READ_MEDIA_IMAGES)!=PackageManager.PERMISSION_GRANTED){
                //izin verilmemiş izin istiyoruz
                if(ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),Manifest.permission.READ_MEDIA_IMAGES)){
                    //snackbar gösterip kullanıcıya neden izin istediğimizi söyleyebiliriz.
                    Snackbar.make(view,"Galeriye ulaşıp görsel seçmemiz gerekiyor!",Snackbar.LENGTH_INDEFINITE).setAction(
                        "izin ver",
                        View.OnClickListener {
                            //izin isteyeceğiz.
                            permissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)
                        }
                    ).show()
                }
                else{
                    //izin isteyeceğiz
                    permissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)

                }
            }
            else{
                //izin verilmiş,galeriye gidebilir.
                val intenToGallery=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intenToGallery)
            }


        }
        else{
            //READ_EXTERNAL_STORAGE izinini var mı yok mu kontrol ediyoruz izin verilmediyse if içine giriyor.
            if(ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                //izin verilmemiş izin istiyoruz
                if(ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),Manifest.permission.READ_EXTERNAL_STORAGE)){
                    //snackbar gösterip kullanıcıya neden izin istediğimizi söyleyebiliriz.
                    Snackbar.make(view,"Galeriye ulaşıp görsel seçmemiz gerekiyor!",Snackbar.LENGTH_INDEFINITE).setAction(
                        "izin ver",
                        View.OnClickListener {
                            //izin isteyeceğiz.
                            permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                        }
                    ).show()
                }
                else{
                    //izin isteyeceğiz
                    permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)

                }
            }
            else{
                //izin verilmiş,galeriye gidebilir.
                val intenToGallery=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intenToGallery)
            }


        }




    }


    private fun registerLauncher(){

        //galeriye gitme işi
        //StartActivityForResult: sonucunu bize geri döndürür.
        activityResultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result->
            if(result.resultCode==AppCompatActivity.RESULT_OK){//galeride görseli seçtiyse
                val intentFromResult=result.data
                if(intentFromResult!=null){
                    secilenGorsel=intentFromResult.data

                    try {
                        if(Build.VERSION.SDK_INT>=28){
                            val source=ImageDecoder.createSource(requireActivity().contentResolver,secilenGorsel!!)
                            secilenBitmap=ImageDecoder.decodeBitmap(source)
                            binding.imageView.setImageBitmap(secilenBitmap)
                        }
                        else{
                            secilenBitmap=MediaStore.Images.Media.getBitmap(requireActivity().contentResolver,secilenGorsel)
                            binding.imageView.setImageBitmap(secilenBitmap)
                        }
                    }
                    catch (e:IOException){
                        println(e.localizedMessage)
                    }
                }
            }
        }


        //RequestPermission:izin iste
        permissionLauncher=registerForActivityResult(ActivityResultContracts.RequestPermission()){
            result->
            if(result){
                //izin verildi galeriye gidebiliriz.
                val intenToGallery=Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intenToGallery)
            }
            else{
                //izin verilmedi
                Toast.makeText(requireContext(),"izin verilmedi",Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}