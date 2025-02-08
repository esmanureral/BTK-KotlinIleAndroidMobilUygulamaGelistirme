package com.esmanureral.yemektarif

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.esmanureral.yemektarif.databinding.FragmentListeBinding
import com.esmanureral.yemektarif.databinding.FragmentTarifBinding
import com.google.android.material.snackbar.Snackbar

class TarifFragment : Fragment() {
    private var _binding: FragmentTarifBinding?=null
    private val binding get()=_binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        //READ_EXTERNAL_STORAGE izinini var mı yok mu kontrol ediyoruz izin verilmediyse if içine giriyor.
        if(ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
           //izin verilmemiş izin istiyoruz
            if(ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),Manifest.permission.READ_EXTERNAL_STORAGE)){
                //snackbar gösterip kullanıcıya neden izin istediğimizi söyleyebiliriz.
                Snackbar.make(view,"Galeriye ulaşıp görsel seçmemiz gerekiyor!",Snackbar.LENGTH_INDEFINITE).setAction(
                    "izin ver",
                    View.OnClickListener {
                        //izin isteyeceğiz.
                    }
                ).show()
            }
            else{
                //izin isteyeceğiz
            }
        }
        else{
            //izin verilmiş,galeriye gidebilir.
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}