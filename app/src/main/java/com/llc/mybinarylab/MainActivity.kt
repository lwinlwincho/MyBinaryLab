package com.llc.mybinarylab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.llc.mybinarylab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var linearLayoutManager: LinearLayoutManager

    var categoryList= mutableListOf<CategoryModel>()

    private val popularItemAdapter by lazy {
        PopularItemAdapter()
    }

    private val categoryItemAdapter by lazy {
        CategoryItemAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gridLayoutManager = GridLayoutManager(this, 2)
        linearLayoutManager = LinearLayoutManager(this)

        binding.rvCategory.apply {
            layoutManager = gridLayoutManager
            adapter = categoryItemAdapter
        }

        binding.rvPopularCourse.apply {
            layoutManager = linearLayoutManager
            adapter = popularItemAdapter
        }

      val seeLessCategoryList = mutableListOf(
            CategoryModel("Business English", R.drawable.ic_business, R.color.business_color),
            CategoryModel("Grammar", R.drawable.ic_grammer, R.color.grammar_color),
            CategoryModel("Speaking", R.drawable.ic_speaking, R.color.speaking_color),
            CategoryModel("Phonetics", R.drawable.ic_phonetics, R.color.phonetics_color)
        )
        categoryItemAdapter.submitList(seeLessCategoryList)

        binding.tvSeeMore.setOnClickListener {
            val seeMoreCategoryList = mutableListOf(
                CategoryModel("Business English", R.drawable.ic_business, R.color.business_color),
                CategoryModel("Grammar", R.drawable.ic_grammer, R.color.grammar_color),
                CategoryModel("Speaking", R.drawable.ic_speaking, R.color.speaking_color),
                CategoryModel("Phonetics", R.drawable.ic_phonetics, R.color.phonetics_color),
                CategoryModel("Writing", R.drawable.ic_writing, R.color.writing_color),
                CategoryModel("Listening", R.drawable.ic_listening, R.color.listening_color)
            )
            categoryItemAdapter.submitList(seeMoreCategoryList)
            binding.tvSeeLess.visibility = View.VISIBLE
            binding.tvSeeMore.visibility = View.GONE
        }

        binding.tvSeeLess.setOnClickListener{
            categoryItemAdapter.submitList(seeLessCategoryList)
            binding.tvSeeMore.visibility = View.VISIBLE
            binding.tvSeeLess.visibility = View.GONE
        }

        val popularList = listOf(
            PopularModel("How to write English Better", R.drawable.ic_card_heading),
            PopularModel("How to write English Better", R.drawable.ic_card_heading),
            PopularModel("How to write English Better", R.drawable.ic_card_heading),
            PopularModel("How to write English Better", R.drawable.ic_card_heading),
            PopularModel("How to write English Better", R.drawable.ic_card_heading)
        )
        popularItemAdapter.submitList(popularList)

    }
}