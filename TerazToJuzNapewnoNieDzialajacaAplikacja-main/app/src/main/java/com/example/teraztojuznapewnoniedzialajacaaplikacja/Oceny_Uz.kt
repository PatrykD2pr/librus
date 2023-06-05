package com.example.teraztojuznapewnoniedzialajacaaplikacja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class Oceny_Uz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oceny_uz)

            supportActionBar!!.setDisplayShowHomeEnabled(true)
            supportActionBar!!.setIcon(R.drawable.icona_apki)

            val kolekcja = intent.extras
            supportActionBar!!.title = kolekcja?.getString("nazwa").toString() + " " + kolekcja?.getString("haslo").toString()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.lista_dan_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val kolekcja = intent.extras
        if (kolekcja != null) {
            if (id == R.id.PierwszyPrzedmiot && kolekcja!=null) {
                val nowe = Intent(this, DaneUz::class.java)
                nowe.putExtras(kolekcja)
                startActivity(nowe)
                finish()
            } else if (id == R.id.DrugiPrzedmiot && kolekcja!=null) {
                val nowe = Intent(this, Oceny_Uz::class.java)
                nowe.putExtras(kolekcja)
                startActivity(nowe)
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}