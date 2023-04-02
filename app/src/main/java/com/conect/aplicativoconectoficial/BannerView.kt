package com.conect.aplicativoconectoficial

import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.conect.aplicativoconectoficial.databinding.BannerItemBinding
import com.squareup.picasso.Picasso

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