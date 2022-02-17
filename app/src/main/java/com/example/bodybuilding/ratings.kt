package com.example.bodybuilding

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.*
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ratings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratings)

        val f_rating = findViewById<RatingBar>(R.id.rating)
        val s_rating = findViewById<RatingBar>(R.id.rating2)
        val t_rating = findViewById<RatingBar>(R.id.rating3)
        val q_rating = findViewById<RatingBar>(R.id.rating4)
        val btn = findViewById<Button>(R.id.submit_btn)
        val tool = findViewById<Toolbar>(R.id.tool_bar2)

        tool.title = "LET'S BUILD IT"
        setSupportActionBar(tool)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        f_rating.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { ratingBar: RatingBar?, fl: Float, fromuser: Boolean ->
                Toast.makeText(
                    this,
                    "Thank you for $fl rating on User Experience",
                    Toast.LENGTH_LONG
                ).show()
            }
        s_rating.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { ratingBar: RatingBar?, fl: Float, fromuser: Boolean ->
                Toast.makeText(
                    this,
                    "Thank you for $fl rating on Valuable Information",
                    Toast.LENGTH_LONG
                ).show()
            }
        t_rating.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { ratingBar: RatingBar?, fl: Float, fromuser: Boolean ->
                Toast.makeText(this, "Thank you for $fl rating on Navigation", Toast.LENGTH_LONG)
                    .show()
            }
        q_rating.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { ratingBar: RatingBar?, fl: Float, fromuser: Boolean ->
                Toast.makeText(this, "Thank you for $fl rating on Overall app", Toast.LENGTH_LONG)
                    .show()
            }

        btn.setOnClickListener {
            createCustomToast()

           Handler().postDelayed({
               startActivity(Intent(this, MainActivity::class.java))
               finish()
            }, 2000)
        }

    }

    fun createCustomToast(){
        val toast = layoutInflater.inflate(R.layout.custom_toast,findViewById(R.id.custom_toast))
        with(Toast(applicationContext)){
            duration = Toast.LENGTH_SHORT
            view = toast
            show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.rating_menu,menu)
        return true
    }
    fun exit()
    {
        finishAffinity()
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home-> startActivity(Intent(this,MainActivity::class.java))
            R.id.pwr -> exit()
        }
        return true
    }
}