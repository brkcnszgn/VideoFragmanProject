package com.example.videofragmanproject.mock

import androidx.fragment.app.Fragment
import com.example.videofragmanproject.activities.fragment.MovieFragment
import com.example.videofragmanproject.model.FragmanModel


object MockData {
    fun getMoviesFragment(fragmentSize: Int): List<Fragment> {
        val fragmentList = ArrayList<Fragment>()
        repeat(fragmentSize) {
            val fragmentmovie = MovieFragment()
            fragmentList.add(fragmentmovie)
        }
        return fragmentList
    }

    fun getFragmanList(): List<FragmanModel> {
        val fragmanList: ArrayList<FragmanModel> = ArrayList()
        val frg1 = FragmanModel(
            "https://i.ytimg.com/vi/8jmW_C50BRA/maxresdefault.jpg",
            "Film1",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4"

        )
        val frg3 = FragmanModel(
            "https://i.ytimg.com/vi/iu0J_yaGVgg/maxresdefault.jpg",
            "film2",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4"
        )
        val frg4 = FragmanModel(
            "https://iasbh.tmgrup.com.tr/608b80/800/420/0/0/1200/629?u=https://isbh.tmgrup.com.tr/sbh/2020/03/01/yabanci-filmi-nerede-cekildi-konusu-ne-yabanci-filmi-oyunculari-kimler-1583080578899.jpg",
            "film3",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4"
        )
        val frg5 = FragmanModel(
            "https://i2.milimaj.com/i/milliyet/75/0x0/5ead377d55428310902597f8.jpg",
            "film4",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"
        )
        val frg6 = FragmanModel(
            "https://img-s1.onedio.com/id-5bf822b17ec803ce39d77683/rev-0/w-1000/h-563/f-jpg/s-313e6f2c2753f01696e976ca61c408baa0e8657f.jpg",
            "film5",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"
        )
        val frg7 = FragmanModel(
            "https://i4.hurimg.com/i/hurriyet/75/770x0/5975e3eec03c0e12fc936f69",
            "film6",
            "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
        )

        fragmanList.add(frg1)
        fragmanList.add(frg3)
        fragmanList.add(frg4)
        fragmanList.add(frg5)
        fragmanList.add(frg6)
        fragmanList.add(frg7)
        fragmanList.add(frg1)


        return fragmanList
    }

}
/*
val detailList: ArrayList<DetailFragmanModel> = ArrayList()

val dtl1 = DetailFragmanModel(
    "DAVID O.  RUSSELL (Fighter, I Heart Huckabees)",
    "7.0",
    "Pat Peoples’ın orijinal bir teorisi var. Hayatı, aslında Tanrı’nın çektiği bir filmdir. Görevi, duygularını daha iyi anlamaktır, eğer böyle olursa Tanrı ona bir mutlu son (ayrıldığı eşi Nikki ile" +
            " barışma) bahşedecektir. Bakalım akıl hastanesinden yeni çıkmış olan Pat mutlu sonuna kavuşabilecek mi? " +
            "Orjinal adı Silver Linings Playbook olan Umut Işığım filmi Kanal D Dijital Film Arşivinde! Umut Işığım oyuncuları, hikayesi, yönetmeni, gösterim yılı, konusu, başrollerinde kim var ve hangi" +
            " firma detaylarını bulabileceğiniz filmi hd kalitesinde, tek part, dublajlı izleyebilirsiniz.",
    "BRADLEY COOPER (American Hustle, Hangover Trilogy, Limitless), JENNIFER LAWRENCE (American Hustle, The Hunger Games, Winter’s Bone), ROBERT DE NIRO (The Family, Kiling Season), JACKI WEAVER (Stoker," +
            " Animal Kingdom)",
    "https://i4.hurimg.com/i/hurriyet/75/770x0/5975e3eec03c0e12fc936f69"
)
val dtl2 = DetailFragmanModel(
    "MIKE BINDER (Reign Over Me, The Upside Of Anger)",
    "6.0",
    "Orjinal adı BLACK OR WHITE olan Siyah ya da Beyaz filmi Kanal D Dijital Film Arşivinde! Siyah ya da Beyaz oyuncuları, hikayesi, yönetmeni, gösterim yılı, konusu, başrollerinde kim var ve " +
            "hangi firma detaylarını bulabileceğiniz filmi hd kalitesinde, tek part, dublajlı izleyebilirsiniz.En iyi film ve en iyi yönetmen (Dances With Wolves – Kurtlarla Dans) olmak üzere 2 Oscar ödülüne sahip KEVIN COSTNER ile En iyi yardımcı kadın oyuncu (The Help – Yardımcı) Oscar’lı OCTAVIA SPENCER başrolde…\n" +
            "\n" +
            "Karısını trafik kazasında kaybetmiş olan savcı Elliot Anderson’ın (Costner) doğumda kaybettiği kızının acısını biraz olsun siyahi torunu Eloise’i büyüterek atlatmaya çalışmaktadır. Kederiyle başa çıkmaya çalışan Elliot’ın hayatı, Eloise’in Afro Amerikalı anneannesi Rowena’nın (Spencer) torununu kızın babası" +
            " Reggie’nin velayetine girmesini istemesiyle bir anda altüst olur. Elliot ise kızının ölümündeki ihmalkârlığından dolayı suçladığı, uyuşturucu bağımlısı Reggie’yle kendini bir velayet savaşının ortasında bulacaktır…",
    "KEVIN COSTNER (Draft Day, 3 Days To Kill), OCTAVIA SPENCER (Paradise, The Help), JENNIFER EHLE (Robocop, Zero Dark Thirty),\n" +
            "\n" +
            "ANTHONY MACKIE (A Many Splintered Thing, Runner Runner)",
    "https://i2.milimaj.com/i/milliyet/75/0x0/5ead377d55428310902597f8.jpg"
)
val dtl3 = DetailFragmanModel(
    "Ibo",
    "5.0",
    "\"Orjinal adı BLACK OR WHITE olan Siyah ya da Beyaz filmi Kanal D Dijital Film Arşivinde! Siyah ya da Beyaz oyuncuları, hikayesi, yönetmeni, gösterim yılı, konusu, başrollerinde kim var ve\n" +
            "                    \" hangi firma detaylarını bulabileceğiniz filmi hd kalitesinde, tek part, dublajlı izleyebilirsiniz.En iyi film ve en iyi yönetmen (Dances With Wolves – Kurtlarla Dans) olmak üzere 2 Oscar ödülüne sahip KEVIN COSTNER ile En iyi yardımcı kadın oyuncu (The Help – Yardımcı) Oscar’lı OCTAVIA SPENCER başrolde…\n" +
            "                    \"Karısını trafik kazasında kaybetmiş olan savcı Elliot Anderson’ın (Costner) doğumda kaybettiği kızının acısını biraz olsun siyahi torunu Eloise’i büyüterek atlatmaya çalışmaktadır. Kederiyle başa çıkmaya çalışan Elliot’ın hayatı, Eloise’in Afro Amerikalı anneannesi Rowena’nın (Spencer) torununu kızın babası\"",
    "Reggie’nin velayetine girmesini istemesiyle bir anda altüst olur. Elliot ise kızının ölümündeki ihmalkârlığından dolayı suçladığı, uyuşturucu bağımlısı Reggie’yle kendini bir velayet savaşının ortasında bulacaktır…",

    "https://i4.hurimg.com/i/hurriyet/75/770x0/5975e3eec03c0e12fc936f69"
)
val dtl4 = DetailFragmanModel(
    "Ibo",
    "5.0",
    "\"Orjinal adı BLACK OR WHITE olan Siyah ya da Beyaz filmi Kanal D Dijital Film Arşivinde! Siyah ya da Beyaz oyuncuları, hikayesi, yönetmeni, gösterim yılı, konusu, başrollerinde kim var ve\n" +
            "                    \" hangi firma detaylarını bulabileceğiniz filmi hd kalitesinde, tek part, dublajlı izleyebilirsiniz.En iyi film ve en iyi yönetmen (Dances With Wolves – Kurtlarla Dans) olmak üzere 2 Oscar ödülüne sahip KEVIN COSTNER ile En iyi yardımcı kadın oyuncu (The Help – Yardımcı) Oscar’lı OCTAVIA SPENCER başrolde…\n" +
            "                    \"Karısını trafik kazasında kaybetmiş olan savcı Elliot Anderson’ın (Costner) doğumda kaybettiği kızının acısını biraz olsun siyahi torunu Eloise’i büyüterek atlatmaya çalışmaktadır. Kederiyle başa çıkmaya çalışan Elliot’ın hayatı, Eloise’in Afro Amerikalı anneannesi Rowena’nın (Spencer) torununu kızın babası\"",
    "Reggie’nin velayetine girmesini istemesiyle bir anda altüst olur. Elliot ise kızının ölümündeki ihmalkârlığından dolayı suçladığı, uyuşturucu bağımlısı Reggie’yle kendini bir velayet savaşının ortasında bulacaktır…",

    "https://i4.hurimg.com/i/hurriyet/75/770x0/5975e3eec03c0e12fc936f69"
)


detailList.add(dtl1)
detailList.add(dtl2)
detailList.add(dtl3)
detailList.add(dtl4)

return detailList
}
}*/