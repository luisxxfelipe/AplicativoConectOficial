package com.conect.aplicativoconectoficial

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import com.conect.aplicativoconectoficial.databinding.FragmentManicureBinding

class ManicureFragment: Fragment(R.layout.fragment_manicure) {

    private var binding: FragmentManicureBinding? = null

    private val categoriaAdapter = ATAdapter({CategoriasView(it)})
    private val bannerAdapter = ATAdapter({BannerView(it)})
    private val estabelecimentosAdpater = ATAdapter({EstabelecimentosView(it)})
    private val MaisEstabelecimentos = ATAdapter({MaisEstabelecimentosView(it)})

    private var filtros = arrayOf(

        FiltrarItem(1,"Ordenar", closeicon = R.drawable.ic_setabaixo),
        FiltrarItem(2,"Distância", closeicon = R.drawable.ic_distancia),
        FiltrarItem(4,"Promoção", icon = R.drawable.ic_promocao),
        FiltrarItem(5,"Filtros", closeicon = R.drawable.ic_filtro),

    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoriaAdapter.items = arrayListOf(
            Categorias(1, "https://img3.gratispng.com/dy/bbec1a0515157d5b15d25e4aa0e419bc/L0KzQYm3U8I3N5N4fZH0aYP2gLBuTf5icZ0yeeR9LX3kfrrqlgJmNZ9mgd42cHBvecTvTf5icZ0yTdNrOHa1doS7gfY0bWozT6oCNUC4QoS4VcIzOGg1SqcEM0C6PsH1h5==/kisspng-nail-art-manicure-nail-polish-nail-5ab8f2f34af3e9.787505231522070259307.png", "Mãos", 0xFFE91D2D),
            Categorias(2, "https://img3.gratispng.com/dy/42193cd4912fabd8c9af312b54b5cf8d/L0KzQYm3U8I5N5N6j5H0aYP2gLBuTgBmbJpojeRuLX3kfrrqlgJmNZhqhJ93YXnvg37phfF2fKoyiNN7bHB4gn71gflte146edRrMUXpR7boUvQ4QV89S6k6M0O7SIK8UsIzOWE3UacENUm1PsH1h5==/kisspng-pedicure-manicure-gel-nails-beauty-parlour-nails-5abb15f7ea2d79.8371338815222102959592.png", "Pés", 0xFFE91D2D),
            )

        bannerAdapter.items = arrayListOf(
            Banner(1, "https://webtrends.net.br/wp-content/uploads/2020/10/Como-atrair-clientes-para-barbearia.png"),
            Banner(2, "https://ath2.unileverservices.com/wp-content/uploads/sites/2/2016/08/barbearia-perfeita-782x439.jpg"),
            Banner(3, "https://guiafranquiasdesucesso.com/wp-content/uploads/2016/08/franquia-barbearia.jpg"),
        )

        estabelecimentosAdpater.items = arrayListOf(
            Estabelecimentos(1, "https://i.pinimg.com/564x/af/06/a9/af06a9335d023133aced3c6d02ae7a62.jpg", "Barba Branca"),
            Estabelecimentos(2, "https://i.pinimg.com/564x/d7/2b/41/d72b41afcac16ea6c8739665ea403e2c.jpg", "Velha Guarda"),
            Estabelecimentos(3, "https://i.pinimg.com/564x/8a/78/4c/8a784c7a435453ee0bf53cebb04f9743.jpg", "Cortes e Tons"),
            Estabelecimentos(4, "https://i.pinimg.com/564x/32/f8/79/32f8796902b8ef96194b076ef801ca62.jpg", "Ponto da Barba"),
            Estabelecimentos(5, "https://i.pinimg.com/564x/58/e0/58/58e0585264a0d2928c934dd35d3f4e1c.jpg", "Barba na Barra"),
            Estabelecimentos(6, "https://i.pinimg.com/564x/21/70/c9/2170c9dd15f95c78d649f98686f41edd.jpg", "Pente Fino"),
            Estabelecimentos(7, "https://i.pinimg.com/736x/ef/89/82/ef8982895221526d7aaddefff4c9577f.jpg", "Belle Époque"),

            )

        MaisEstabelecimentos.items = arrayListOf(
            MaisEstabelecimentos(1, "https://i.pinimg.com/564x/af/06/a9/af06a9335d023133aced3c6d02ae7a62.jpg", "Barba Branca","Barbearia", 4.4, 1.2),
            MaisEstabelecimentos(2, "https://i.pinimg.com/564x/d7/2b/41/d72b41afcac16ea6c8739665ea403e2c.jpg", "Velha guarda","Barbearia", 4.9, 2.6),
            MaisEstabelecimentos(3, "https://i.pinimg.com/564x/8a/78/4c/8a784c7a435453ee0bf53cebb04f9743.jpg",  "Cortes e tons","Barbearia",4.6, 0.2),
            MaisEstabelecimentos(4, "https://i.pinimg.com/564x/32/f8/79/32f8796902b8ef96194b076ef801ca62.jpg",  "Ponto da Barba", "Barbearia",4.4, 8.9),
            MaisEstabelecimentos(5, "https://i.pinimg.com/564x/58/e0/58/58e0585264a0d2928c934dd35d3f4e1c.jpg",  "Barba da Barra", "Barbearia",4.7, 3.2),
            MaisEstabelecimentos(6, "https://i.pinimg.com/564x/21/70/c9/2170c9dd15f95c78d649f98686f41edd.jpg",  "Pente fino", "Barbearia",4.2, 2.2),
            MaisEstabelecimentos(7, "https://i.pinimg.com/736x/ef/89/82/ef8982895221526d7aaddefff4c9577f.jpg",  "Belle Époque", "Barbearia",4.8, 7.2),

            )

        binding = FragmentManicureBinding.bind(view)

        binding?.let {
            it.recyclerViewCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.recyclerViewCategory.adapter = categoriaAdapter

            it.rvBanners.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvBanners.adapter = bannerAdapter

            it.rvEstabelecimentos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvEstabelecimentos.adapter = estabelecimentosAdpater

            it.rvMaisOpcoes.layoutManager = LinearLayoutManager(requireContext())
            it.rvMaisOpcoes.adapter = MaisEstabelecimentos

            it.rvBanners.addOnScrollListener(object: RecyclerView.OnScrollListener(){
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if(newState == RecyclerView.SCROLL_STATE_IDLE)  {
                        notifyPositionChanged(recyclerView)
                    }
                }
            })

            addDots(it.dots, bannerAdapter.items.size, 0)

            filtros.forEach { filtros->
                it.chipGroup.addView(filtros.toChip((requireContext())))
            }
        }
    }

    private fun addDots(container: LinearLayout, size:Int, position: Int){
        container.removeAllViews()

        Array(size){
            val textView = TextView(context).apply{
                text = getString(R.string.dotted)
                textSize = 28f

                setTextColor(

                    if(position == it) ContextCompat.getColor(context, android.R.color.black)
                    else ContextCompat.getColor(context, android.R.color.darker_gray)
                )
            }

            container.addView(textView)
        }
    }

    private var position: Int? = RecyclerView.NO_POSITION
    private val snapHelper = LinearSnapHelper()

    private fun notifyPositionChanged(recyclerView: RecyclerView){
        val layoutManager = recyclerView.layoutManager
        val view = snapHelper.findSnapView(layoutManager)
        val position = if(view == null) RecyclerView.NO_POSITION else layoutManager?.getPosition(view)

        val positionChanged = this.position != position
        if(positionChanged){
            println("$position")
            addDots(binding!!.dots, bannerAdapter.items.size, position ?: 0)
        }

        this.position = position
    }
}

