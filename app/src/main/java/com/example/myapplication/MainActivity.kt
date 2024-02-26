package com.example.myapplication

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.imageView)
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)

        val popupMenu = androidx.appcompat.widget.PopupMenu(this, imageView)
        popupMenu.inflate(R.menu.popupmenu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu1 -> {
                    textView.text = "Нажат пункт PopupMenu1"
                    true
                }

                R.id.menu2 -> {
                    textView.text = "Нажат пункт PopupMenu2"
                    true
                }

                R.id.menu3 -> {
                    textView.text = "Нажат пункт PopupMenu3"
                    true
                }

                else -> false
            }
        }
        imageView.setOnClickListener {
            popupMenu.show()
        }
        val menu2 = PopupMenu(this, button)
        menu2.inflate(R.menu.menu2)
        menu2.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.red -> {
                    textView.background = ColorDrawable(Color.RED)
                    textView.text = "Вы выбрали красный цвет"
                }

                R.id.yellow -> {
                    textView.background = ColorDrawable(Color.YELLOW)
                    textView.text = "Вы выбрали жёлтый цвет"
                }

                R.id.green -> {
                    textView.background = ColorDrawable(Color.GREEN)
                    textView.text = "Вы выбрали зелёный цвет"
                }
            }
            false
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            menu2.setForceShowIcon(true)
        }
        button.setOnClickListener {
            menu2.show()
        }
        val menu3 = PopupMenu(this, textView)
        menu3.inflate(R.menu.menu3)
        menu3.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.one -> resources.getDimensionPixelSize(R.dimen.small)
                R.id.two -> resources.getDimensionPixelSize(R.dimen.medium)
                R.id.three -> resources.getDimensionPixelSize(R.dimen.large)
                else -> null
            }?.let { size ->
                textView.textSize = size.toFloat()
            }
            false
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            menu3.setForceShowIcon(true)
        }
        textView.setOnClickListener {
            menu3.show()
        }
    }
}