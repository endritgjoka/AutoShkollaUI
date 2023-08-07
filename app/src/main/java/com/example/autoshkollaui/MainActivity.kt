package com.example.autoshkollaui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.autoshkollaui.Fragments.ExamsFragment
import com.example.autoshkollaui.Fragments.LiteratureFragment
import com.example.autoshkollaui.Fragments.PlayLearnFragment
import com.example.autoshkollaui.Fragments.ProfileFragment
import com.example.autoshkollaui.Fragments.QuestionsFragment
import com.example.autoshkollaui.databinding.ActivityMainBinding
import com.google.android.material.appbar.CollapsingToolbarLayout

class MainActivity : AppCompatActivity(), ToolbarTitleChangeListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var  toolbar:  Toolbar

    private val examsFragment: ExamsFragment = ExamsFragment()
    private val profileFragment: ProfileFragment = ProfileFragment()
    private val literatureFragment: LiteratureFragment = LiteratureFragment()
    private val questionsFragment: QuestionsFragment = QuestionsFragment()
    private val playLearnFragment: PlayLearnFragment = PlayLearnFragment()

    private var activeFragment: Fragment = examsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.title = "testet"
//        val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbarLayout)
//        collapsingToolbarLayout.title = "Testet"

        val bottomSheetCategoryFragment = BottomSheetCategoryFragment()

        binding.collapsingToolbarLayout.title = "Testet"
        binding.chooseCategoryCard.setOnClickListener{
            bottomSheetCategoryFragment.show(supportFragmentManager, "Zgjedhni kategorine")
        }

        initializeFragments()
        changeFragments()


    }

    private fun initializeFragments() {
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_container, profileFragment, profileFragment.tag)
            .hide(profileFragment).commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_container, literatureFragment, literatureFragment.tag)
            .hide(literatureFragment).commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_container, questionsFragment, questionsFragment.tag)
            .hide(questionsFragment).commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_container, playLearnFragment, playLearnFragment.tag)
            .hide(playLearnFragment).commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.frame_container, examsFragment, examsFragment.tag)
            .commit()

        activeFragment = examsFragment
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().hide(activeFragment).show(fragment)
            .commit()
        activeFragment = fragment
    }

    private fun changeFragments() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuitem ->
            when (menuitem.itemId) {
                R.id.tests -> {
                    Log.i("MYTAG","U SHTYP")
                    val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbarLayout)
                    collapsingToolbarLayout.title = "Testet"
                    replaceFragment(examsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.literatura -> {
                    Log.i("MYTAG","U SHTYP")
                    val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbarLayout)
                    collapsingToolbarLayout.title = "Literatura"
                    replaceFragment(literatureFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.profili -> {
                    Log.i("MYTAG","U SHTYP")
                    val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbarLayout)
                    collapsingToolbarLayout.title = "Profili"
                    replaceFragment(profileFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.pyetjet -> {
                    Log.i("MYTAG","U SHTYP")
                    val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbarLayout)
                    collapsingToolbarLayout.title = "Pyetjet"
                    replaceFragment(questionsFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.luaj_meso -> {
                    Log.i("MYTAG","U SHTYP")
                    val collapsingToolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbarLayout)
                    collapsingToolbarLayout.title = "Luaj&Meso"
                    replaceFragment(playLearnFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    override fun onTitleChanged(title: String) {
        supportActionBar?.title = title
    }
}
