package ua.icedragon.imageslideshow.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ua.icedragon.imageslideshow.R;
import ua.icedragon.imageslideshow.adapter.ImageSlideAdapter;
import ua.icedragon.imageslideshow.model.Product;

public class CardsSliderView extends FrameLayout {

    @Bind(R.id.slider_view_pager) ViewPager viewPagerView;
    @Bind(R.id.slider_dots_container) ViewGroup dotsContainerView;

    public CardsSliderView(Context context) {
        this(context, null);
    }

    public CardsSliderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CardsSliderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.cards_slider_layout, this);
        ButterKnife.bind(this);
    }

    public void bindData(List<Product> products) {
        viewPagerView.setAdapter(new ImageSlideAdapter(getContext(), products));
        viewPagerView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                updateDotsContainer(viewPagerView.getAdapter().getCount(), position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        updateDotsContainer(products.size(), viewPagerView.getCurrentItem());
    }

    private void updateDotsContainer(int dotsCount, int selectedItemIndex) {
        dotsContainerView.removeAllViews();
        for (int i = 0; i < dotsCount; i++) {
            final boolean isSelected = i == selectedItemIndex;
            View dotView = createDotView(isSelected);
            dotsContainerView.addView(dotView);
        }
    }

    private View createDotView(boolean isSelected) {
        ImageView dotView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.dot_image_layout, dotsContainerView, false);
        dotView.setImageResource(isSelected ? R.drawable.slider_selected_dot_draw : R.drawable.slider_unselected_dot_draw);
        return dotView;
    }


}
