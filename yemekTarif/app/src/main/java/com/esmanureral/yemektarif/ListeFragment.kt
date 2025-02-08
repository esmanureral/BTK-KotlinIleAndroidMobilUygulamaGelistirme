package com.esmanureral.yemektarif

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.esmanureral.yemektarif.databinding.FragmentListeBinding


class ListeFragment : Fragment() {
    private var _binding:FragmentListeBinding?=null
    private val binding get()=_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListeBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener{yeniEkle(it)}//bunu yazmadan onClick metodu çalışmaz


    }
    //burası çalıştığında floatingbutona tıklandığında tarifFragmentine geçiş yapılıyor
    fun yeniEkle(view: View){
        val action=ListeFragmentDirections.actionListeFragmentToTarifFragment(bilgi = "yeni",id=0)
        Navigation.findNavController(view).navigate(action)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}