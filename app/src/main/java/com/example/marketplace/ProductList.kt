package com.example.marketplace

object ProductList {

    private val data = arrayOf(
        arrayOf("Nike Air Tuban",
            "The Air Tuban 1 is a footwear pioneer—but the OG silhouette isn't too old to learn new tricks.",
            "$160.50",
            R.drawable.airtobon),

        arrayOf("Pentol Frozen Mafia Pentol",
            "'Sekarang kita siapkan paket 15.000'",
            "$9.25",
            R.drawable.adit),

        arrayOf("Iphone 14 Pro Max 128GB",
            "Experience iPhone in a whole new way with the Dynamic Island.",

            "$1500",
            R.drawable.ifun),

        arrayOf("Wagyu A5 Sirloin 200gr",
            "Daging Wahyu",
            "$169.99",
            R.drawable.wagyu),

        arrayOf("Fender Professional II Stratocaster",
            "The Fender Professional II Stratocaster ",
            "$1499.99",
            R.drawable.fendir),

        arrayOf("Victorinox Swiss Army I.N.O.X.",
            "The Best Swiss Army Watch ",
            "$595",
            R.drawable.sws),


        )
    val listData: ArrayList<product>
        get() {
            val list = arrayListOf<product>()
            for (aData in data) {
                val produk = product()
                produk.name = aData[0] as String
                produk.description = aData[1] as String
                produk.price = aData[2] as String
                produk.foto = aData[3]as Int
                list.add(produk)
            }
            return list
        }

}