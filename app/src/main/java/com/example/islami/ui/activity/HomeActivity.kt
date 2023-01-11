package com.example.islami.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islami.adapter.BaseActivity
import com.example.islami.R
import com.example.islami.databinding.ActivityHomeBinding
import com.example.islami.ui.fragment.HadethFragment
import com.example.islami.ui.fragment.QuranFragment
import com.example.islami.ui.fragment.TasbehFragment

class HomeActivity : BaseActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navigation.setOnItemSelectedListener { item ->
            if (item.itemId == com.example.islami.R.id.navigation_quran) {
                pushFragment(QuranFragment())
            } else if (item.itemId == com.example.islami.R.id.navigation_hadeth) {
                pushFragment(HadethFragment())
            } else if (item.itemId == com.example.islami.R.id.navigation_tasbeh) {
                pushFragment(TasbehFragment())
            }
            true
        }
        binding.navigation.selectedItemId = com.example.islami.R.id.navigation_quran
    }

    fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out
            )
            .replace(com.example.islami.R.id.fragment_container, fragment)
            .commit()
    }
}
//       setCustomAnimations(
//            enter = R.anim.slide_in,
//            val fragment = FragmentB()
//        supportFragmentManager.commit {
//        exit = R.anim.fade_out,
//            popEnter = R.anim.fade_in,
//            popExit = R.anim.slide_out
//        )
//        replace(R.id.fragment_container, fragment)
//        addToBackStack(null)
//    }










