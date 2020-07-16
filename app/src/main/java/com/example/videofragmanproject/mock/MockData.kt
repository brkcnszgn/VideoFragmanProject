package com.example.videofragmanproject.mock

import androidx.fragment.app.Fragment
import com.example.videofragmanproject.activities.fragment.MovieFragment
import com.example.videofragmanproject.model.DetailFragmanModel
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
    fun getFragmanList():  List<FragmanModel> {
        val fragmanList: ArrayList<FragmanModel> = ArrayList()
        val frg1 = FragmanModel(
            "https://i.ytimg.com/vi/8jmW_C50BRA/maxresdefault.jpg",
            "Film1",
            getDetailFragmanModel()
        )
        val frg3 = FragmanModel(
            "https://i.ytimg.com/vi/iu0J_yaGVgg/maxresdefault.jpg",
            "film2",
            getDetailFragmanModel()
        )
        val frg4 = FragmanModel(
            "https://iasbh.tmgrup.com.tr/608b80/800/420/0/0/1200/629?u=https://isbh.tmgrup.com.tr/sbh/2020/03/01/yabanci-filmi-nerede-cekildi-konusu-ne-yabanci-filmi-oyunculari-kimler-1583080578899.jpg",
            "film3",
            getDetailFragmanModel()
        )
        val frg5 = FragmanModel(
            "https://i2.milimaj.com/i/milliyet/75/0x0/5ead377d55428310902597f8.jpg",
            "film4",
            getDetailFragmanModel()
        )
        val frg6 = FragmanModel(
            "https://img-s1.onedio.com/id-5bf822b17ec803ce39d77683/rev-0/w-1000/h-563/f-jpg/s-313e6f2c2753f01696e976ca61c408baa0e8657f.jpg",
            "film5",
            getDetailFragmanModel()
        )
        val frg7 = FragmanModel(
            "https://i4.hurimg.com/i/hurriyet/75/770x0/5975e3eec03c0e12fc936f69",
            "film6",
            getDetailFragmanModel()
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

    fun getDetailFragmanModel(): List<DetailFragmanModel> {
        val detailList: ArrayList<DetailFragmanModel> = ArrayList()

        val dtl1 = DetailFragmanModel(
            "Ali",
            "7.0",
            "Ozgur,Ozgur,Ozgur,OzgurOzgur,Ozgur",
            "https://i4.hurimg.com/i/hurriyet/75/770x0/5975e3eec03c0e12fc936f69"
        )
        val dtl2 = DetailFragmanModel(
            "Veli",
            "6.0",
            "Ozgur,Ozgur,Ozgur,OzgurOzgur,Ozgur",
            "https://i2.milimaj.com/i/milliyet/75/0x0/5ead377d55428310902597f8.jpg"
        )
        val dtl3 = DetailFragmanModel(
            "Ibo",
            "5.0",
            "Ozgur,Ozgur,Ozgur,OzgurOzgur,Ozgur",
            "https://i4.hurimg.com/i/hurriyet/75/770x0/5975e3eec03c0e12fc936f69"
        )
        val dtl4 = DetailFragmanModel(
            "Sema",
            "4.0",
            "Ozgur,Ozgur,Ozgur,OzgurOzgur,Ozgur",
            "https://img-s1.onedio.com/id-5bf822b17ec803ce39d77683/rev-0/w-1000/h-563/f-jpg/s-313e6f2c2753f01696e976ca61c408baa0e8657f.jpg"
        )

        detailList.add(dtl1)
        detailList.add(dtl2)
        detailList.add(dtl3)
        detailList.add(dtl4)

        return detailList
    }
}