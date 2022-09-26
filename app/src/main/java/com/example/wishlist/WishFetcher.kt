package com.example.wishlist

class WishFetcher {
    companion object {
        //val name = listOf("Dahlia Cline", "Kevin Miranda", "Kaya Austin", "Laila Calderon", "Marquise Rhodes", "Fletcher Patel", "Luz Barron", "Kamren Dudley", "Jairo Foster", "Lilah Sandoval", "Ansley Blake", "Slade Sawyer", "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould")
        val name = listOf("")
        val price = listOf("")
        val url = listOf("")
        //val price = "5.99"
        //val url = "www.example.com"


        fun getItems(): MutableList<Cart> {
            var sizeTotal = name.size
            var items : MutableList<Cart> = ArrayList()
            for (i in 0..sizeTotal) {
                val item = Cart(name[i], price[i], url[i])
                //val item = eachItem
                items.add(item)
            }
            return items
        }
        fun addItems(name: String, price: String, url:String): MutableList<Cart> {
            var items: MutableList<Cart> = ArrayList()
            val item = Cart(name, price, url)
            items.add(item)

            return items
        }
    }
}