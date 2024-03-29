package com.example.marketplace

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyFriendsFragment : Fragment() {

    private var fab_btn: FloatingActionButton? = null
    private var listMyFriends: RecyclerView? = null
    private lateinit var listTeman: MutableList<MyFriend>
    private var db: AppDatabase? = null
    private var myFriendDao: MyFriendDAO? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.my_friends_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()

    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        myFriendDao = db?.myFriendDAO()
    }

    private fun initView() {
        fab_btn = activity?.findViewById(R.id.fabAddFriend)
        listMyFriends = activity?.findViewById(R.id.listMyFriends)

        fab_btn?.setOnClickListener {
            (activity as MoveActivity).tampilMyFriendsAddFragment()
        }
        ambilDataTeman()

    }

    private fun tampilTeman() {

        listMyFriends?.layoutManager = LinearLayoutManager(activity)
        listMyFriends?.adapter = MyFriendAdapter(
            requireActivity(),
            listTeman as ArrayList<MyFriend>
        )
    }

    private fun ambilDataTeman() {
        listTeman = ArrayList()
        myFriendDao?.ambilSemuaTeman()?.observe(requireActivity()) { r ->
            listTeman = r.toMutableList()
            when {
                listTeman.isEmpty() -> {
                    Toast.makeText(requireActivity(), "Belum Ada Data", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    tampilTeman()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fab_btn = null
        listMyFriends = null

    }

    companion object {
        fun newInstance(): MyFriendsFragment {
            return MyFriendsFragment()
        }
    }
}