package com.rk.recyclerviewwithdatabinding.ui.movies

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rk.recyclerviewwithdatabinding.R
import com.rk.recyclerviewwithdatabinding.data.response.HealthItem
import com.rk.recyclerviewwithdatabinding.ui.home.DetailActivity
import com.rk.recyclerviewwithdatabinding.utils.ApiException
import com.rk.recyclerviewwithdatabinding.utils.NoInternetException
import kotlinx.android.synthetic.main.movies_fragment.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class HealthFragment : Fragment(), RecyclerViewClickListener, KodeinAware {
    //This is how we get instances fom Kodein
    // You will get an error with kodein() method then
    // You need to import import org.kodein.di.android.x.kodein manually
    override val kodein: Kodein by kodein()
    private val factory: HeathViewModelFactory by instance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProvider(this, factory).get(HealthViewModel::class.java)


        try {
            viewModel.getMoviesListFromRepository()

        } catch (e: ApiException) {

        } catch (noInternet: NoInternetException) {

        }

        progress_bar.visibility = View.VISIBLE
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            recycler_view.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    HealthAdapter(
                        movies.genre,
                        this
                    )
                progress_bar.visibility = View.INVISIBLE

            }
        })

    }

    override fun onRecyclerViewItemClick(view: View, movieItem: HealthItem) {

        when (view.id) {

            R.id.imageView -> {
            Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), DetailActivity::class.java)
                intent.putExtra("data", movieItem as Parcelable)
                // To pass any data to next activity
               // intent.putExtra("title", movieItem.name)
               /* intent.putExtra("title", movieItem.height)
                intent.putExtra("title", movieItem.mass)
                intent.putExtra("title", movieItem.hair_color)
                intent.putExtra("title", movieItem.skin_color)
                intent.putExtra("title", movieItem.eye_color)
                intent.putExtra("title", movieItem.birth_year)
                intent.putExtra("title", movieItem.gender)*/


                // start your next activity
                startActivity(intent)
        }




        }

    }

}
