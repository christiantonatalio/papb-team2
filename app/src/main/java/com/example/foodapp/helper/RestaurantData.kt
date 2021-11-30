package com.example.foodapp.helper

import com.example.foodapp.R
import com.example.foodapp.model.Restaurant

object RestaurantData {
    private val names = arrayOf(
        "Angkringan Lik Man",
        "Cilok Gajahan",
        "Dawet Mbah Hari",
        "Es Buah PK",
        "Gudeg Bromo",
        "Jenang Bu Gesti",
        "Lupis Mbah Satinem",
        "Mie Ayam Bu Tumini",
        "Nasi Goreng Sapi Notaris",
        "Oseng Mercon Bu Narti",
        "Pukis Koh Yung",
        "Roti Bakar Tower",
        "Siomay Telkom",
        "Wedang Ronde Mbah Paiyem",
        "Wedang Tahu Bu Sukardi"
    )

    private val address = arrayOf(
        "Jalan Wongsodirjan, Gedong Tengen, Sosromenduran, Kota Yogyakarta, Daerah Istimewa Yogyakarta",
        "Jalan Ngadisuryan, Patehan, Kraton, Patehan, Kraton, Kota Yogyakarta, Daerah Istimewa Yogyakarta",
        "Pasar Beringharjo tepatnya di pintu sayap utara",
        "Jalan Pakuningratan Nomor 76 A, Cokrodiningratan, Jetis, Kota Yogyakarta, Daerah Istimewa Yogyakarta",
        "Jl. Affandi No.2-A, Santren, Caturtunggal, Kec. Depok, Kabupaten Sleman, Daerah Istimewa Yogyakarta ",
        "Pasar Lempuyangan, Jalan Hayam Wuruk, Kota Yogyakarta, Daerah Istimewa Yogyakarta",
        "Jl. Bumijo No.52-40, Bumijo, Kec. Jetis, Kota Yogyakarta, Daerah Istimewa Yogyakarta",
        "Jalan Imogiri Timur Nomor 187, Umbulharjo, Kota Yogyakarta, Daerah Istimewa Yogyakarta",
        "Jl. Atmosukarto No.11, Kotabaru, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta",
        "Jalan KH. Ahmad Dahlan, Ngampilan, Kota Yogyakarta, Daerah Istimewa Yogyakarta",
        "Jl. Abu Bakar Ali No.2, Kotabaru, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta",
        "69QH+8V3, Pogung Kidul, Sinduadi, Kec. Mlati, Kabupaten Sleman, Daerah Istimewa Yogyakarta",
        "Jl. Juadi No.1, Kotabaru, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta",
        "Jalan Kauman, Kota Yogyakarta, Daerah Istimewa Yogyakarta",
        "Jalan Kranggan Nomor 75, Cokrodiningratan, Jetis, Kota Yogyakarta, Daerah Istimewa Yogyakarta"
        )

    private val priceRange = arrayOf(
        "Mulai dari 1000",
        "250/cilok",
        "Mulai dari 5000",
        "Mulai dari 9000",
        "Mulai dari 14000",
        "Mulai dari 4000",
        "Mulai dari 5000",
        "Mulai dari 8000",
        "Mulai dari 13000",
        "Mulai dari 15000",
        "Mulai dari 25000",
        "Mulai dari 10000",
        "Sayur 2000, Siomay 3000, Telur 4000",
        "5000",
        "6000"
    )

    private val image = arrayOf(
        R.drawable.angkringan_likman,
        R.drawable.cilok_gajahan,
        R.drawable.dawet_mbahhari,
        R.drawable.esbuah_pk,
        R.drawable.gudeg_bromo,
        R.drawable.jenang_bugesti,
        R.drawable.lupis_mbahsatinem,
        R.drawable.mieayam_butumini,
        R.drawable.nasigorengsapi_notaris,
        R.drawable.osengmercon_bunarti,
        R.drawable.pukis_kohyung,
        R.drawable.rotibakar_tower,
        R.drawable.siomay_telkom,
        R.drawable.wedangronde_mbahpaiyem,
        R.drawable.wedangtahu_busukardi
    )

    val listData: ArrayList<Restaurant>
        get(){
            val list = arrayListOf<Restaurant>()
            for (position in names.indices){
                val restaurant = Restaurant(
                    position+1,
                    names[position],
                    address[position],
                    priceRange[position],
                    image[position]
                )
                list.add(restaurant)
            }
            return list
        }
}
