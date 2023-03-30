package com.conect.aplicativoconectoficial

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import com.conect.aplicativoconectoficial.databinding.FragmentBarbeariaBinding

class BarbeariaFragment: Fragment(R.layout.fragment_barbearia) {

    private var binding: FragmentBarbeariaBinding? = null

    private val categoriaAdapter = ATAdapter({
        CategoriasView(it)
    })

    private var filtros = arrayOf(

        FiltrarItem(1,"Ordenar", closeicon = R.drawable.ic_setabaixo),
        FiltrarItem(2,"Distância", closeicon = R.drawable.ic_distancia),
        FiltrarItem(4,"Promoção", icon = R.drawable.ic_promocao),
        FiltrarItem(5,"Filtros", closeicon = R.drawable.ic_filtro),

    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoriaAdapter.items = arrayListOf(
            Categorias(1, "https://www.dlf.pt/dfpng/maxpng/211-2114752_bigotes-png.png", "Cabelos", 0xFFB6D048),
            Categorias(2, "https://www.dlf.pt/dfpng/maxpng/27-273960_shivaji-maharaj-png.png", "Barbas", 0xFFE91D2D),
            Categorias(3, "https://www.dlf.pt/dfpng/maxpng/511-5117162_barba-png.png", "Sobrancelhas", 0xFFB6D048),
        )

        binding = FragmentBarbeariaBinding.bind(view)

        binding?.let {
            it.recyclerViewCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.recyclerViewCategory.adapter = categoriaAdapter
            filtros.forEach { filtros->
                it.chipGroup.addView(filtros.toChip((requireContext())))
            }
        }
    }
}

