package com.conect.aplicativoconectoficial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.conect.aplicativoconectoficial.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) // está pegando a view principal e esta inflando esse layout e armazenando-o

        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews(){
        val tabLayout = binding.addTab
        val viewPager = binding.viewPage
        val adapter = TabViewPagerAdapter(this)
        viewPager.adapter = adapter
        viewPager.isUserInputEnabled = false

        TabLayoutMediator(tabLayout, viewPager){ tab, position -> tab.text = getString(adapter.tabs[position]) }.attach()
    }
}

class TabViewPagerAdapter(fa:FragmentActivity): FragmentStateAdapter(fa){

    val tabs = arrayOf(R.string.Barbeiro, R.string.Manicure, R.string.Maquiadoras, R.string.Cabeleireira)
    val fragments = arrayOf(BarbeariaFragment(), ManicureFragment(), MaquiadoraFragment(), CabeleireiraFragment())

    override fun getItemCount() =  fragments.size // quantos fragmentos o paginador vai gerenciar

    override fun createFragment(position: Int): Fragment { // metodo que vai ser disparado e cria um fragmento novo
        return fragments[position]
    }
}

class MarketPlaceFragment: Fragment(){

}