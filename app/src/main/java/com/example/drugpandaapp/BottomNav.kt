package com.example.drugpandaapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNav : AppCompatActivity() {
    class HomeFragment : Fragment(R.layout.fragment_home)
    class MessagesFragment : Fragment(R.layout.fragment_messages)
    class OrderFragment : Fragment(R.layout.fragment_order)
    class NotificationsFragment : Fragment(R.layout.fragment_notifications)
    class ProfileFragment : Fragment(R.layout.fragment_profile)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bottom_nav)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            insets
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { menuitem ->
            when (menuitem.itemId){
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.messages -> {
                    loadFragment(MessagesFragment())
                    true
                }
                R.id.order -> {
                    loadFragment(OrderFragment())
                    true
                }
                R.id.notifications -> {
                    loadFragment(NotificationsFragment())
                    true
                }
                R.id.profile -> {
                    true
                }
                else -> false
            }
        }
        if (savedInstanceState == null){
            bottomNavigationView.selectedItemId = R.id.home
        }
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_wrapper, fragment)
            .commit()
    }
}
