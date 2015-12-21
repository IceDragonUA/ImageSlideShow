package ua.icedragon.imageslideshow.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import ua.icedragon.imageslideshow.R;
import ua.icedragon.imageslideshow.model.Product;

public class ImageSlideAdapter extends PagerAdapter {

    private final Context context;
    private final List<Product> products;
    private final LayoutInflater layoutInflater;


    public ImageSlideAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    public Product getItem(int position) {
        return products.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = layoutInflater.inflate(R.layout.pager_item, container, false);
        bind(itemView, getItem(position));
        container.addView(itemView);
        return itemView;
    }

    private void bind(View rootView, Product product) {
        ImageView itemCoverView = (ImageView) rootView.findViewById(R.id.image_display);
        final ProgressBar itemProgressView = (ProgressBar) rootView.findViewById(R.id.progressBar);
        Picasso.with(context).load(product.getImageUrl()).resize(250,150).into(itemCoverView, new Callback() {
            @Override
            public void onSuccess() {
                if (itemProgressView.getVisibility() == View.VISIBLE) {
                    itemProgressView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onError() {
                itemProgressView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
