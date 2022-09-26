package com.example.wishlist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var items: List<Cart>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun View.hideKeyboard() {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }

        val button = findViewById<Button>(R.id.button)

        val nameEditedText = findViewById<EditText>(R.id.nameEditText)
        val priceEditedText = findViewById<EditText>(R.id.priceEditText)
        val urlEditedText = findViewById<EditText>(R.id.urlEditText)

        button.setOnClickListener {
            WishFetcher.addItems(nameEditedText.toString(), priceEditedText.toString(), urlEditedText.toString())

            // Lookup the RecyclerView in activity layout
            val itemsRv = findViewById<RecyclerView>(R.id.wishlistRv)
            // Fetch the list of emails
            items = WishFetcher.getItems()
            // Create adapter passing in the list of emails
            val adapter = CartAdapter(items)
            // Attach the adapter to the RecyclerView to populate items
            itemsRv.adapter = adapter
            // Set layout manager to position the items
            itemsRv.layoutManager = LinearLayoutManager(this)

            nameEditedText.hideKeyboard()
            nameEditedText.getText().clear()
            priceEditedText.hideKeyboard()
            priceEditedText.getText().clear()
            urlEditedText.hideKeyboard()
            urlEditedText.getText().clear()
        }
    }
}