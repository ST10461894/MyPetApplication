package com.android.myapplication

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView




class SecondActivity: AppCompatActivity() {

    private lateinit var petImageView: ImageView
    private lateinit var hungerText: TextView
    private lateinit var cleanText: TextView
    private lateinit var happyText: TextView
    private var hungerLevel:Double = 10.0
    private var cleanLevel :Double= 10.0
    private var happyLevel:Double = 10.0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        petImageView = findViewById(R.id.petImageView)
        hungerText = findViewById(R.id.hungerHealthText)
        cleanText = findViewById(R.id.cleanHealthText)
        happyText = findViewById(R.id.happyHealthText)
        val feedButton: Button = findViewById(R.id.feedButton)
        val cleanButton: Button = findViewById(R.id.cleanButton)
        val playButton: Button = findViewById(R.id.playButton)

        val buttons= arrayListOf( feedButton,cleanButton,playButton)

        buttons.forEachIndexed{
                index, button ->
            button.setOnClickListener {
                when(index){
                    0-> feedPet()
                    1-> cleanPet()
                    2->playWithPet()
                }
                updatePetImage(index)
                animatePetImage()
            }

        }




    }

    private fun animatePetImage() {
        val translation = ObjectAnimator.ofFloat(petImageView, "translationX", -500f, 0f)
        translation.duration = 1000 // Duration in milliseconds
        translation.start()
    }

    private fun updatePetImage(index:Int) {


        val images= arrayListOf(
            R.drawable.pets_feeding,
            R.drawable.pet_cleanig,
            R.drawable.pet_palaying

        )

        petImageView.setImageResource(images[index])

    }

    @SuppressLint("SetTextI18n")
    private fun feedPet() {

        val onePercentOfTen = 10 * 0.01
         hungerLevel -= onePercentOfTen

        hungerText.text = "${hungerLevel.toString()} %"


    }
    @SuppressLint("SetTextI18n")
    private fun cleanPet() {


        val onePercentOfTen = 10 * 0.01
        cleanLevel += onePercentOfTen

        cleanText.text = "${cleanLevel.toString()} %"


    }
    @SuppressLint("SetTextI18n")
    private fun playWithPet() {

        val onePercentOfTen = 10 * 0.01
         happyLevel += onePercentOfTen

        happyText.text = " ${happyLevel.toString()} % "


    }

}
