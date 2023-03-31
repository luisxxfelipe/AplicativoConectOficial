package com.conect.aplicativoconectoficial

import android.graphics.drawable.GradientDrawable
import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.conect.aplicativoconectoficial.databinding.BannerItemBinding
import com.conect.aplicativoconectoficial.databinding.CategoriaItensBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class BannerView(viewGroup: ViewGroup): ATViewHolder<Banner, BannerItemBinding>(
    BannerItemBinding::inflate,
    viewGroup
) {
    override fun bind(item: Banner) {
        Picasso.get()
            .load(item.banner_url)
            .into(binding.imgBanner)
    }

}