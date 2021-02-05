package com.example.alltherecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView


class MainActivity : AppCompatActivity() {
    private lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById<ListView>(R.id.recipe_list_view)
        (R.id.recipe_list_view)
         val recipelist = Recipe.getRecipesFromFile("recipes.json",this)

        val listItems= arrayOfNulls<String>(recipelist.size)
        for (i in 0 until
        recipelist.size){
            val recipe = recipelist[i]
            listItems[i] = recipe.title
        }
        val adapter = ArrayAdapter (this,android.R.layout.simple_list_item_1,listItems)
        listView.adapter=adapter
        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            // 1
            val selectedRecipe = recipelist[position]

            // 2
            val detailIntent = RecipeDetailActivity.newIntent(context, selectedRecipe)

            // 3
            startActivity(detailIntent)
        }


    }


}