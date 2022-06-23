package ir.mamhesam.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import ir.mamhesam.wikipedia.databinding.ActivityMainBinding
import ir.mamhesam.wikipedia.fragments.ExploreFragment
import ir.mamhesam.wikipedia.fragments.ProfileFragment
import ir.mamhesam.wikipedia.fragments.TrendFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutMain,
            binding.toolbarMain,
            R.string.openDrawer,
            R.string.closeDrawer
        )
        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        binding.navigationViewMain.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.menu_writer -> {
                    Toast.makeText(this, "I am writer", Toast.LENGTH_SHORT).show()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_photographer -> {
                    Toast.makeText(this, "I am photographer", Toast.LENGTH_SHORT).show()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                }
                R.id.menu_video_maker -> {

                }
                R.id.menu_translator -> {

                }
                //------
                R.id.menu_wikipedia -> {

                }
                R.id.menu_wikimedia -> {

                }
            }

            true
        }
        firstRun()
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_explore -> {
                   replaceFragment(ExploreFragment())
                }
                R.id.nav_trend -> {
                    replaceFragment(TrendFragment())
                }
                R.id.nev_profile -> {
                    replaceFragment(ProfileFragment())
                }
            }

            true
        }
        binding.bottomNavigation.setOnItemReselectedListener {}
    }

    private fun replaceFragment (fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()
    }
    private fun firstRun(){
        replaceFragment(ExploreFragment())
        binding.bottomNavigation.selectedItemId = R.id.nav_explore
    }
}