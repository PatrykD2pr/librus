package com.example.teraztojuznapewnoniedzialajacaaplikacja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class logowanie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.drawable.icona_apki)
        supportActionBar!!.title = "Mini Librus"

        findViewById<TextView>(R.id.txtvw1).setOnClickListener {
            Toast.makeText(applicationContext, "Login = Imię | Hasło = Nazwisko", Toast.LENGTH_LONG).show()
        }
        findViewById<Button>(R.id.btn1).setOnClickListener {
            var imie = findViewById<EditText>(R.id.editText1).text.toString()
            var nazwisko = findViewById<EditText>(R.id.editText2).text.toString()
            if(imie != "" && nazwisko != ""){
            doNastepnego(imie, nazwisko)
            }
            else{
                Toast.makeText(applicationContext, "Podaj login i hasło", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun doNastepnego(nazwa: String, hasło: String) {
        val kolekcja = Bundle()
        kolekcja.putString("nazwa", nazwa)
        kolekcja.putString("haslo", hasło)
        val intent = Intent(this, DaneUz::class.java)
        intent.putExtras(kolekcja)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.lista_dan_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val kolekcja = intent.extras
        if (kolekcja != null) {
            val id = item.itemId
            if (id == R.id.PierwszyPrzedmiot) {
                val dane = Intent(this, DaneUz::class.java)
                startActivity(dane)
                finish()
            } else if (id == R.id.DrugiPrzedmiot) {
                val oceny = Intent(this, Oceny_Uz::class.java)
                startActivity(oceny)
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}