package com.example.password

import android.content.Intent
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
import com.example.password.crearCredencial.CreatePasswordItem
import com.example.password.fragments.CreatePassword
import com.example.password.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    //private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding1 = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding1.root)
        /*Navegacion*/
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawer.addDrawerListener(toggle)

        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

    }

    /*Navegacion*/
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_Item_one -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainer, CreatePassword())
                    commit()
                }
            }
            R.id.nav_Item_two -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainer, HomeFragment())
                    commit()
                }
            }
            R.id.nav_Item_three -> {
                val intent = Intent(this, CreatePasswordItem::class.java)
                startActivity(intent)
                finish()
            }
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
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menusearch, menu)
        return true
    }


}