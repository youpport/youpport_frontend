package com.example.youpport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.youpport.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


private const val TAG_CHATBOT = "fragment_chat_bot"
private const val TAG_HOME = "home_fragment"
private const val TAG_MY_PAGE = "my_page_fragment"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        var bnv_main = findViewById(R.id.navigationView) as BottomNavigationView

        bnv_main.itemIconTintList = null

        val id = intent.getStringExtra("id")

        bnv_main.run { setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.tab_home -> {
                    // 다른 프래그먼트 화면으로 이동하는 기능
                    val homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.mainFrameLayout, homeFragment).commit()
                }
                R.id.tab_chatbot -> {
                    val chatBotFragment = ChatBotFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.mainFrameLayout, chatBotFragment).commit()
                }
                R.id.tab_mypage -> {
                    val myPageFragment = MyPageFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.mainFrameLayout, myPageFragment).commit()
                }}
        true
        }
            selectedItemId= R.id.tab_home
        }}}
