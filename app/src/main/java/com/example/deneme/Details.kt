package com.example.deneme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.deneme.databinding.ActivityDetailsBinding

class Details : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val takimdetaylari = intent.getSerializableExtra("intentDetails") as Takimlar
        binding.aciklamaText.text = takimdetaylari.aciklama
        binding.imageView.setImageResource(takimdetaylari.foto)
        binding.takimismitext.text= takimdetaylari.name
    }
}