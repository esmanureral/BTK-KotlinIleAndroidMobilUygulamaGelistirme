package com.esmanureral.fragmentvenavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.esmanureral.fragmentvenavigation.databinding.FragmentBirinciBinding

//FRAGMENTTE BİNDİNG BAĞLAMAK DAHA FARKLI

//ARGÜMAN NERDEN ALMAK İSTİYORSAK NAVİGATİONDA ORAYA EKLİYORUZ.

class BirinciFragment : Fragment() {
    private var _binding:FragmentBirinciBinding?=null
    private val binding get()= _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentBirinciBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editText.setText("")
        binding.button.setOnClickListener{
            sonraki(it)
        }
    }

    //birinci fragmentten butona basılınca ikinci fragmente geçmek
    fun sonraki(view:View){
        val isim=binding.editText.text.toString()
        val action=BirinciFragmentDirections.actionBirinciFragmentToIkinciFragment2(isim)
        Navigation.findNavController(view).navigate(action)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}