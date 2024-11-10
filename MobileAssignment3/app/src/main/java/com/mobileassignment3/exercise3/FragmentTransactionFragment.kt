package com.mobileassignment3.exercise3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.mobileassignment3.R

class FragmentTransactionFragment : Fragment() {

    private var fragment1: Fragment? = null
    private var fragment2: Fragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transaction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAddFragment1: Button = view.findViewById(R.id.btnAddFragment1)
        val btnAddFragment2: Button = view.findViewById(R.id.btnAddFragment2)
        val btnReplaceWithFragment1: Button = view.findViewById(R.id.btnReplaceWithFragment1)
        val btnReplaceWithFragment2: Button = view.findViewById(R.id.btnReplaceWithFragment2)
        val btnRemoveFragment1: Button = view.findViewById(R.id.btnRemoveFragment1)
        val btnRemoveFragment2: Button = view.findViewById(R.id.btnRemoveFragment2)

        btnAddFragment1.setOnClickListener {
            if (fragment1 == null) {
                fragment1 = Fragment1()
                addFragment(fragment1!!)
            }
        }

        btnAddFragment2.setOnClickListener {
            if (fragment2 == null) {
                fragment2 = Fragment2()
                addFragment(fragment2!!)
            }
        }

        btnReplaceWithFragment1.setOnClickListener {
            replaceFragment(Fragment1())
        }

        btnReplaceWithFragment2.setOnClickListener {
            replaceFragment(Fragment2())
        }

        btnRemoveFragment1.setOnClickListener {
            fragment1?.let {
                removeFragment(it)
            }
        }

        btnRemoveFragment2.setOnClickListener {
            fragment2?.let {
                removeFragment(it)
            }
        }
    }

    private fun addFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun removeFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .remove(fragment)
            .commit()
    }
}