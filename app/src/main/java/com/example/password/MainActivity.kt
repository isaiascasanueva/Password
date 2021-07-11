package com.example.password

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.password.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import androidx.recyclerview.widget.RecyclerView
import com.example.password.DAO.NamePassword
import com.example.password.DAO.Usuario
import com.example.password.adapter.SectionAdapterPassword

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private  lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer= findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)



        val recicler = findViewById<RecyclerView>(R.id.section_recycler)
        /* se asigna un layout manager */
        recicler.layoutManager = LinearLayoutManager(this)
        /**/
        val sectionAdapter =SectionAdapterPassword(this)

        recicler.adapter= sectionAdapter

        sectionAdapter.submitList(downloadFakePassword())
    }

    private fun createuser() {

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        when(item.itemId){
            R.id.nav_Item_one -> Toast.makeText(this,"Item 1", Toast.LENGTH_SHORT).show()
            R.id.nav_Item_two -> Toast.makeText(this,"Item 2", Toast.LENGTH_SHORT).show()
            R.id.nav_Item_three -> Toast.makeText(this,"Item 3", Toast.LENGTH_SHORT).show()
            }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {

        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menusearch, menu)
        return true
    }

    private fun downloadFakePassword():List<NamePassword>{


        val fantasy1 = Usuario(1,"raul_mau@gmail.com","fs322fdsdfsdf")
        val password = listOf(fantasy1)


        val fantasy = Usuario(2,"13isaias@live.com","sd336fsdffd32sdf")
        val pass = listOf(fantasy)


        val passwordEnd = NamePassword("Netflix",password)
        val passwordEnd1 = NamePassword("Youtube",pass)
        return listOf(passwordEnd,passwordEnd1)
    }
}