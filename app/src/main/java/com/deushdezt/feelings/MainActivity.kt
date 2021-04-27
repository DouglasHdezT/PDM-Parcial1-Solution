package com.deushdezt.feelings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    lateinit var nextBtn: Button
    lateinit var prevBtn: Button

    val feelingsViewModel: FeelingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()

        feelingsViewModel.current.observe(this){
            when(it){
                0 -> prevBtn.visibility = View.GONE
                feelingsViewModel.getListLI() -> nextBtn.visibility = View.GONE
                else -> {
                    prevBtn.visibility = View.VISIBLE
                    nextBtn.visibility = View.VISIBLE
                }
            }

            val info = feelingsViewModel.getFeelingInfo(it)
            val fragment = EmojiFragment.newInstance(getString(info.title), info.image)

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.emoji_frame, fragment)
                .commit()
        }
    }

    private fun bind(){
        nextBtn = findViewById(R.id.next_action)
        prevBtn = findViewById(R.id.prev_action)

        nextBtn.setOnClickListener {
            feelingsViewModel.onNext()
        }

        prevBtn.setOnClickListener {
            feelingsViewModel.onPrevious()
        }
    }
}