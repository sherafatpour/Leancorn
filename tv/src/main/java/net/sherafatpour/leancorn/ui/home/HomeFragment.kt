package net.sherafatpour.leancorn.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.lifecycle.asLiveData
import dagger.hilt.android.AndroidEntryPoint
import net.sherafatpour.leancorn.R
import net.sherafatpour.leancorn.databinding.FragmentHomeBinding
import net.sherafatpour.leancorn.databinding.FragmentSplashBinding
import net.sherafatpour.leancorn.model.Category
import net.sherafatpour.leancorn.util.Resource

@AndroidEntryPoint
class HomeFragment : BrowseSupportFragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = getString(R.string.app_name)
        if (savedInstanceState == null) {
            prepareEntranceTransition()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.moviesResponse.asLiveData().observe(viewLifecycleOwner) { resource ->
            when (resource) {

                is Resource.Idle -> {

                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {

                    startEntranceTransition()
                    displayData(resource.data)


                }
                is Resource.Error -> {


                }
                else -> {}
            }
        }
    }

    private fun displayData(categories: List<Category>) {

        val adapter =ArrayObjectAdapter(ListRowPresenter())
        for (category in categories){
            val headerItem = HeaderItem(category.id, category.genre)
            val rowAdapter = ArrayObjectAdapter(PosterPresenter())
            for (movie in category.movies){
                rowAdapter.add(movie)
            }
            adapter.add(ListRow(headerItem, rowAdapter))
        }
        this.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null;

    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}