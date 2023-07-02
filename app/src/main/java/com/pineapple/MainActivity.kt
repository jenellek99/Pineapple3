package com.pineapple

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout.*
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        imageView.startAnimation(fadeInAnimation)
        imageView.visibility = View.VISIBLE
// Assuming you have a reference to your ImageView
        val imageView = findViewById<ImageView>(R.id.imageView)

// Create the fade-out animation
        val fadeOutAnimation = AlphaAnimation(1.0f, 0.0f)
        fadeOutAnimation.duration = 1000 // Set the duration of the animation in milliseconds

// Set an optional listener to perform any actions after the animation finishes
        fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                // Animation started
            }

            override fun onAnimationEnd(animation: Animation?) {
                // Animation ended
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intent)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {
                // Animation repeated
            }
        })

// Apply the animation to the image view
        imageView.startAnimation(fadeOutAnimation)
    }
}

