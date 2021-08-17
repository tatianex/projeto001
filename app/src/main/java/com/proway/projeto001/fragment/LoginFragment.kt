package com.proway.projeto001.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.proway.projeto001.MainActivity
import com.proway.projeto001.R

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private var activityFather : MainActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        activityFather = requireActivity() as? MainActivity

        view.findViewById<Button>(R.id.buttonLogin).apply{
            setOnClickListener {
                activityFather?.replaceFragment(ProductListFragment.newInstance())
                println("I am here!")
            }
        }
    }

}