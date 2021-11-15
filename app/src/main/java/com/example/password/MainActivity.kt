package com.example.password

//import com.example.password.crearCredencial.CreatePasswordItem
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.password.databinding.ActivityMainBinding
import com.example.password.fragments.HomeFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


        private lateinit var toggle: ActionBarDrawerToggle

        companion object {
            const val idprofile = "profile"
        }


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


        val fragment = HomeFragment()
            openGetUser(fragment)

    }

//
//    private fun openCreatePass(view: View, fab: View) {
//        Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//            .setAction("Action", null)
//            .show()
//        fab.visibility = View.GONE
//        val fragment =  CreatePassword()
//        openGetUser(fragment)
//    }


    /*Navegacion*/
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_Item_one -> {
                val fragment = HomeFragment()
                openGetUser(fragment)
            }
            R.id.nav_Item_two -> {
                val fab: View = findViewById(R.id.fab)
                fab.visibility = View.VISIBLE
                supportFragmentManager.beginTransaction().apply {

                    replace(R.id.fragmentContainer, HomeFragment())
                    commit()
                }
            }
            R.id.nav_Item_three -> {
//                val intent = Intent(this, CreatePasswordItem::class.java)
//                startActivity(intent)
//                finish()
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


    private fun openGetUser(fragment: Fragment) {
        val use = intent.extras!!

        val resultado = use.getInt(idprofile)
        val resultado2 = use.getInt(idprofile)
        val r = resultado.toString()
        val bundle = Bundle()
        bundle.putInt("Numero", resultado)
        bundle.putInt("Numero2",resultado2)

        fragment.arguments = bundle

        supportFragmentManager.beginTransaction().apply {

            replace(R.id.fragmentContainer, fragment)
            commit()

        }
    }
}