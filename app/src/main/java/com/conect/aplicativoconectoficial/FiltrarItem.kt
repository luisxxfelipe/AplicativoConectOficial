package com.conect.aplicativoconectoficial

import android.content.Context
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import com.google.android.material.chip.Chip

data class FiltrarItem(
    val id: Int,
    val text: String,
    @DrawableRes val icon: Int? = null,
    val iconsize: Float = 38.0f,
    @DrawableRes val closeicon: Int? = null
)

fun FiltrarItem.toChip(context: Context) : Chip {
    val chip = if(closeicon == null){
        LayoutInflater.from(context).inflate(R.layout.chip_choice, null, false) as Chip
    }else{
        Chip(ContextThemeWrapper(context, com.google.android.material.R.style.Widget_MaterialComponents_Chip_Choice))
    }

    if(closeicon != null)
        chip.setChipBackgroundColorResource(R.color.white)
        chip.setChipBackgroundColorResource(R.color.cinza_sec)

        if(icon != null){
            chip.chipIconSize = iconsize
            chip.setChipIconResource(icon)
            chip.chipStartPadding= 20f
        }else{
            chip.chipIcon = null
        }

        closeicon?.let {
            chip.setCloseIconResource(it)
            chip.isCloseIconVisible= true
        }

    chip.text = text

    return chip
}
