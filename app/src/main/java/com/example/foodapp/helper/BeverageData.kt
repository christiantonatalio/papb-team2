package com.example.foodapp.helper

import com.example.foodapp.R
import com.example.foodapp.model.Beverage

object BeverageData {
    private val names = arrayOf(
        "Boba",
        "Cheestea",
        "Coffee",
        "Es Buah",
        "Es Degan",
        "Es Doger",
        "Es Teler",
        "Jeruk Peras",
        "Jus",
        "Milktea",
        "Mojito",
        "Smoothies",
        "Susu Murni",
        "Es Teh",
        "Thai Tea")

    private val description = arrayOf(
        "Mutiara yang terbuat dari tapioka. Biasanya disajikan sebagai topping dalam berbagai minuman.",
        "Seduhan teh hitam atau teh hijau yang diberi topping berupa krim keju di atasnya.",
        "Minuman hasil seduhan biji kopi yang telah disangrai dan dihaluskan menjadi bubuk. ",
        "Koktail buah asli Indonesia yang terdiri atas buah-buahan seperti blewah, nanas, pepaya, labu, nangka, kolang kaling dll yang dicampur dengan es serut atau es batu dan dipermanis dengan gula cair atau sirup.",
        "Miinuman segar yang terbuat dari daging dan air kelapa yang masih muda.",
        "Minuman es dengan isian ketan hitam, alpukat, kelapa, nangka atau sobekan roti tawar yang di atasnya diberi serutan es dengan sirup merah dan susu.",
        "Koktail buah asli Indonesia yang terdiri atas alpukat, kelapa muda, cincau, nangka, dll, disajikan dengan santan, susu kental manis, daun pandan, gula, dan sedikit garam.",
        "Jeruk murni yang diperas dan disajikan bersama es batu.",
        "Olahan buah dan sayuran yang diblender dengan air, susu, gula, dll yang bervariasi.",
        "Teh yang dicampur dengan susu dalam komposisi tertentu.",
        "Minuman cocktail khas Kuba yang merupakan kombinasi manisnya soda, segar jerus nipis, dan sedikit pedas dari daun mint.",
        "Minuman yang terbuat dari buah atau sayur mentah yang diblender dan dicampur dengan produk susu seperti susu, yogurt, es krim atau keju cottage.\n",
        "Susu yang tak dipasteurisasi dan tidak mengalami penambahan atau pengurangan nutrisi.",
        "Seduhan berbagai varian daun teh yang dicampur dengan es batu.",
        "Minuman Thailand yang terbuat dari teh Ceylon, susu, dan gula serta disajikan panas atau dingin.",
    )

    private val image = arrayOf(
        R.drawable.boba,
        R.drawable.cheesetea,
        R.drawable.coffee,
        R.drawable.es_buah,
        R.drawable.es_degan,
        R.drawable.es_doger,
        R.drawable.es_teler,
        R.drawable.jeruk_peras,
        R.drawable.jus,
        R.drawable.milktea,
        R.drawable.mojito,
        R.drawable.smoothies,
        R.drawable.susu_murni,
        R.drawable.teh,
        R.drawable.thaitea
    )

    val listData: ArrayList<Beverage>
        get(){
            val list = arrayListOf<Beverage>()
            for (position in names.indices){
                val beverage = Beverage(
                    name = names[position],
                    description = description[position],
                    image = image[position]
                )
                list.add(beverage)
            }
            return list
        }
}