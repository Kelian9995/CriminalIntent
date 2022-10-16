package com.bignerdranch.android.criminalintent

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
//Новый DialogFragment куда мы будем помещять изображение преступления
class ZoomDialogFragment : DialogFragment() {
//Я следую соглашению об использовании функции newInstance()
// сопутствующего объекта, и в этой функции я передаю переменную photoFileName,
// которая содержит crime.photoFileName
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.zoom_layout, container, false)
        val imageView = view.findViewById(R.id.zoom_image_view) as ImageView
    //Вывод на дисплей сфотографированное фото
        val photoFileName = arguments?.getSerializable("PHOTO_URI") as String
        imageView.setImageBitmap(BitmapFactory.decodeFile(requireContext().filesDir.path +
                "/" + photoFileName))
        return view
    }

    companion object {
        fun newInstance(photoFileName: String): ZoomDialogFragment {
            val frag = ZoomDialogFragment()
            val args = Bundle()
            args.putSerializable("PHOTO_URI", photoFileName)
            frag.arguments = args
            return frag
        }
    }
}