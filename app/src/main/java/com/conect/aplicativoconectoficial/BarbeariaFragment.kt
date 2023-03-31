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
    private val bannerAdapter = ATAdapter({BannerView(it)})

    private var filtros = arrayOf(

        FiltrarItem(1,"Ordenar", closeicon = R.drawable.ic_setabaixo),
        FiltrarItem(2,"Distância", closeicon = R.drawable.ic_distancia),
        FiltrarItem(4,"Promoção", icon = R.drawable.ic_promocao),
        FiltrarItem(5,"Filtros", closeicon = R.drawable.ic_filtro),

    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoriaAdapter.items = arrayListOf(
            Categorias(1, "https://img3.gratispng.com/dy/e3d1c4a362fa1ba4dc385b9c038aeaa8/L0KzQYm3VMI3N5p3iZH0aYP2gLBuTfJmaaNpRdZ7YYfsfri0kBt2dJ0yTdNuMkC6cbPpWcIzP2MzTKs7MUm1QIi4VcI1P2c3TaUEN0W7Q3B3jvc=/kisspng-beard-drawing-skull-5ae207abb92272.4921920715247625397583.png", "Cabelos", 0xFFB6D048),
            Categorias(2, "https://img3.gratispng.com/dy/09167c452db784d675c2f3c612248565/L0KzQYm3U8I1N5lviZH0aYP2gLBuTfhidpVxfdRqcj3wf8b6lPFkcJYyiNd3Y3nvPb72lgN1aZRtfZ9rZXH1dH7qjPlxNZJ3RdRuYYLnPbL1hL1ud6Z4jNNsaHWwRbLpVfQ1bZY5UdgDOEWxQIG8Wcg2PGo2TaQ6OEa4SYe9U8A0NqFzf3==/kisspng-handlebar-moustache-pencil-moustache-beard-clip-ar-beard-and-moustache-5ab5d4ee49f885.005985491521865966303.png", "Barbas", 0xFFE91D2D),
        )

        bannerAdapter.items = arrayListOf(
            Banner(1, "https://webtrends.net.br/wp-content/uploads/2020/10/Como-atrair-clientes-para-barbearia.png"),
            Banner(2, "https://ath2.unileverservices.com/wp-content/uploads/sites/2/2016/08/barbearia-perfeita-782x439.jpg"),
            Banner(3, "https://guiafranquiasdesucesso.com/wp-content/uploads/2016/08/franquia-barbearia.jpg"),
        )

        binding = FragmentBarbeariaBinding.bind(view)

        binding?.let {
            it.recyclerViewCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.recyclerViewCategory.adapter = categoriaAdapter

            it.rvBanners.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvBanners.adapter = bannerAdapter

            filtros.forEach { filtros->
                it.chipGroup.addView(filtros.toChip((requireContext())))
            }
        }
    }
}

