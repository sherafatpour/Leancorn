package net.sherafatpour.leancorn.ui.home

import android.view.ViewGroup
import androidx.leanback.widget.BaseCardView
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import coil.load
import coil.size.Scale
import coil.size.Size
import net.sherafatpour.leancorn.R
import net.sherafatpour.leancorn.model.Movie


class PosterPresenter : Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val imageCardView = ImageCardView(parent!!.context).apply {
            isFocusable = true
            isFocusableInTouchMode = true
            cardType= BaseCardView.CARD_TYPE_MAIN_ONLY

        }
        return ViewHolder(imageCardView)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {

        val movie = item as Movie
        with(viewHolder!!.view as ImageCardView) {

            mainImageView.load(
                 movie.image_url, builder = {
                scale(Scale.FIT)
                size(400, 500)
                    placeholder(R.drawable.ic_baseline_image_24)
            })

            titleText = movie.name

        }


    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
        with(viewHolder!!.view as ImageCardView) {
            mainImage = null

        }
    }
}