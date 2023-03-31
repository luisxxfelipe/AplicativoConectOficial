package com.conect.aplicativoconectoficial

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import com.conect.aplicativoconectoficial.databinding.FragmentBarbeariaBinding
import com.conect.aplicativoconectoficial.databinding.FragmentMaquiadoraBinding

class MaquiadoraFragment: Fragment(R.layout.fragment_maquiadora) {

    private var binding: FragmentMaquiadoraBinding? = null

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
            Categorias(1, "https://img3.gratispng.com/dy/15411419fdf2f15365da591c3145c0fd/L0KzQYm3VcI5N6togJH0aYP2gLBuTfJmaaZ5kZ95YYLvf8b5TfFzfJprgdVyYXyweLLwkr1qdqVqfARqdHnyfsS0iPFqeqR5RdpqaYKwg8XCjPUuPZM1e6QAZki6QIrrUsUvQWI9S6U7MUS0RYOAVcIzQGE9TKg6Mz7zfri=/kisspng-beauty-parlour-artificial-hair-integrations-hairst-hair-style-5b0c25f8709d25.9183321415275228084613.png", "Rosto", 0xFFB6D048),
            Categorias(2, "https://img3.gratispng.com/dy/15411419fdf2f15365da591c3145c0fd/L0KzQYm3VcI5N6togJH0aYP2gLBuTfJmaaZ5kZ95YYLvf8b5TfFzfJprgdVyYXyweLLwkr1qdqVqfARqdHnyfsS0iPFqeqR5RdpqaYKwg8XCjPUuPZM1e6QAZki6QIrrUsUvQWI9S6U7MUS0RYOAVcIzQGE9TKg6Mz7zfri=/kisspng-beauty-parlour-artificial-hair-integrations-hairst-hair-style-5b0c25f8709d25.9183321415275228084613.png", "Olhos", 0xFFE91D2D),
        )

        binding = FragmentMaquiadoraBinding.bind(view)

        binding?.let {
            it.recyclerViewCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.recyclerViewCategory.adapter = categoriaAdapter
            filtros.forEach { filtros->
                it.chipGroup.addView(filtros.toChip((requireContext())))
            }
        }
    }
}

