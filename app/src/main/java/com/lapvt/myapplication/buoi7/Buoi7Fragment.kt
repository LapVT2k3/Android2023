package com.lapvt.myapplication.buoi7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.lapvt.myapplication.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Buoi7Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Buoi7Fragment : Fragment() {

    companion object {
        // Viết các key, các hằng
        const val NAME = "Vũ Trung Lập"

        // Viết trong đây dễ maintain code
        fun newFragment(data: String): Buoi7Fragment {
            val fragment = Buoi7Fragment()
            val bundle = Bundle()
            bundle.putString("key5", "Đây là string")
            bundle.putString("key6", data)
            fragment.arguments = bundle
            return fragment
        }
    }

    private var btnClickMe: Button? = null

    // Khởi tạo 1 fragment
    // Set style, theme cho từng fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // Tạo view cho fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buoi7, container, false)
    }

    // Khi view khởi tạo xong
    // Khởi tạo các dữ liệu, gọi api, findViewById
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Muốn gọi activity cha, sau đó ép kiểu về activity mà chúng ta muốn
//        (activity as Buoi7Activity): Ép kiểu từ activity về Buoi7Activity, có thể bị lỗi khi
//        activity đó ép kiểu về null
//        (activity as? Buoi7Activity): Trong trường hợp ép kiểu thất bại thì kết quả trả về là null

        btnClickMe = view.findViewById(R.id.btnClickMe)
        btnClickMe?.setOnClickListener {
            (activity as? Buoi7Activity)?.toastSomething("Pro")
            (activity as? Buoi7Activity)?.so = "2"
        }

        val text = arguments?.getString("key5", "")
        btnClickMe?.text = text
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    // Phải hủy view trước khi hủy fragment
    // Dùng khi cần lấy 1 số dữ liệu từ trên view trước khi chúng bị hủy
    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    // Detach khởi activity
    override fun onDetach() {
        super.onDetach()
    }
}